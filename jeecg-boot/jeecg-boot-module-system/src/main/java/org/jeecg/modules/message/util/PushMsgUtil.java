package org.jeecg.modules.message.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.jeecg.modules.message.entity.SysMessage;
import org.jeecg.modules.message.entity.SysMessageTemplate;
import org.jeecg.modules.message.handle.enums.SendMsgStatusEnum;
import org.jeecg.modules.message.service.ISysMessageService;
import org.jeecg.modules.message.service.ISysMessageTemplateService;
import org.jeecg.modules.system.entity.SysAnnouncement;
import org.jeecg.modules.system.service.ISysAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消息生成工具
 */

@Component
public class PushMsgUtil {

    @Autowired
    private ISysMessageService sysMessageService;

    @Autowired
    private ISysMessageTemplateService sysMessageTemplateService;

    @Autowired
    private Configuration freemarkerConfig;

    @Autowired
    private ISysAnnouncementService sysAnnouncementService;

    /**
     * @param msgType 消息类型 1短信 2邮件 3微信
     * @param templateCode    消息模板码
     * @param map     消息参数
     * @param sentTo  接收消息方
     */
    public boolean sendMessage(String msgType, String templateCode, Map<String, String> map, String sentTo) {
        List<SysMessageTemplate> sysSmsTemplates = sysMessageTemplateService.selectByCode(templateCode);
        SysMessage sysMessage = new SysMessage();
        if (sysSmsTemplates.size() > 0) {
            SysMessageTemplate sysSmsTemplate = sysSmsTemplates.get(0);
            sysMessage.setEsType(msgType);
            sysMessage.setEsReceiver(sentTo);
            //模板标题
            String title = sysSmsTemplate.getTemplateName();
            //模板内容
            String content = sysSmsTemplate.getTemplateContent();
            if(map!=null) {
            	 for (Map.Entry<String, String> entry : map.entrySet()) {
                     String str = "${" + entry.getKey() + "}";
                     title = title.replace(str, entry.getValue());
                     content = content.replace(str, entry.getValue());
                 }
            }
            sysMessage.setEsTitle(title);
            sysMessage.setEsContent(content);
            sysMessage.setEsParam(JSONObject.toJSONString(map));
            sysMessage.setEsSendTime(new Date());
            sysMessage.setEsSendStatus(SendMsgStatusEnum.WAIT.getCode());
            sysMessage.setEsSendNum(0);

            //临时
            SysAnnouncement sysAnnouncement = new SysAnnouncement();
            sysAnnouncement.setUserIds("e9ca23d68d884d4ebb19d07889727dae");
            sysAnnouncement.setTitile(title);
            sysAnnouncement.setMsgContent(content);
            sysAnnouncement.setSendTime(new Date());
            sysAnnouncement.setMsgType("USER");
            sysAnnouncement.setSendStatus("1");
            sysAnnouncement.setDelFlag("0");
            sysAnnouncementService.saveAnnouncement(sysAnnouncement);

            if(sysMessageService.save(sysMessage)) {
				return true;
			}
        }
        return false;
    }

    /**
     * 推送站内通知
     * @param templateCode    消息模板码
     * @param map     消息参数
     * @param sysAnnouncement  消息对象
     */
    public boolean pushContent(String templateCode, Map<String, String> map, SysAnnouncement sysAnnouncement) {
        List<SysMessageTemplate> sysSmsTemplates = sysMessageTemplateService.selectByCode(templateCode);
        if (sysSmsTemplates.size() > 0) {
            SysMessageTemplate sysSmsTemplate = sysSmsTemplates.get(0);
            //模板标题
            String title = sysSmsTemplate.getTemplateName();
            //模板内容
            String content = sysSmsTemplate.getTemplateContent();
            StringWriter stringWriter = new StringWriter();
            Template template = null;
            try {
                template = new Template("SysMessageTemplate", content, freemarkerConfig);
                template.process(map, stringWriter);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (TemplateException e) {
                e.printStackTrace();
                return false;
            }
            content = stringWriter.toString();
            sysAnnouncement.setUserIds(sysAnnouncement.getUserIds()+",");
            sysAnnouncement.setTitile(title);
            sysAnnouncement.setMsgContent(content);
            sysAnnouncement.setSendTime(new Date());
            sysAnnouncement.setMsgType("ALL");
            sysAnnouncementService.saveAnnouncement(sysAnnouncement);
        }
        return false;
    }
}
