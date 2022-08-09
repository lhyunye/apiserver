(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1818294a","chunk-1818294a"],{4004:function(e,t,a){"use strict";a("f721")},"418f":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-drawer",{staticStyle:{height:"calc(100% - 55px)",overflow:"auto","padding-bottom":"53px"},attrs:{title:e.title,maskClosable:!0,width:e.drawerWidth,placement:"right",closable:!0,visible:e.visible},on:{close:e.handleCancel}},[a("template",{slot:"title"},[a("div",{staticStyle:{width:"100%"}},[a("span",[e._v(e._s(e.title))]),a("span",{staticStyle:{display:"inline-block",width:"calc(100% - 51px)","padding-right":"10px","text-align":"right"}},[a("a-button",{staticStyle:{height:"20px",width:"20px",border:"0px"},attrs:{icon:"appstore"},on:{click:e.toggleScreen}})],1)])]),a("a-spin",{attrs:{spinning:e.confirmLoading}},[a("a-form",{attrs:{form:e.form}},[a("a-form-item",{attrs:{label:"用户账号",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["username",e.validatorRules.username],expression:"[ 'username', validatorRules.username]"}],attrs:{placeholder:"请输入用户账号",readOnly:!!e.model.id}})],1),e.model.id?e._e():[a("a-form-item",{attrs:{label:"登陆密码",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["password",e.validatorRules.password],expression:"[ 'password', validatorRules.password]"}],attrs:{type:"password",placeholder:"请输入登陆密码"}})],1),a("a-form-item",{attrs:{label:"确认密码",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["confirmpassword",e.validatorRules.confirmpassword],expression:"[ 'confirmpassword', validatorRules.confirmpassword]"}],attrs:{type:"password",placeholder:"请重新输入登陆密码"},on:{blur:e.handleConfirmBlur}})],1)],a("a-form-item",{attrs:{label:"用户姓名",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["realname",e.validatorRules.realname],expression:"[ 'realname', validatorRules.realname]"}],attrs:{placeholder:"请输入用户姓名"}})],1),a("a-form-item",{attrs:{label:"工号",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["workNo",e.validatorRules.workNo],expression:"[ 'workNo', validatorRules.workNo]"}],attrs:{placeholder:"请输入工号"}})],1),a("a-form-item",{attrs:{label:"职务",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("j-select-position",{directives:[{name:"decorator",rawName:"v-decorator",value:["post",{}],expression:"['post', {}]"}],attrs:{placeholder:"请选择职务",multiple:!1}})],1),a("a-form-item",{directives:[{name:"show",rawName:"v-show",value:!e.roleDisabled,expression:"!roleDisabled"}],attrs:{label:"角色分配",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-select",{staticStyle:{width:"100%"},attrs:{mode:"multiple",placeholder:"请选择用户角色",optionFilterProp:"children"},model:{value:e.selectedRole,callback:function(t){e.selectedRole=t},expression:"selectedRole"}},e._l(e.roleList,(function(t,r){return a("a-select-option",{key:r.toString(),attrs:{value:t.id}},[e._v("\n            "+e._s(t.roleName)+"\n          ")])})),1)],1),a("a-form-item",{directives:[{name:"show",rawName:"v-show",value:!e.departDisabled,expression:"!departDisabled"}],attrs:{label:"部门分配",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input-search",{attrs:{placeholder:"点击右侧按钮选择部门",readOnly:""},on:{search:e.onSearch},model:{value:e.checkedDepartNameString,callback:function(t){e.checkedDepartNameString=t},expression:"checkedDepartNameString"}},[a("a-button",{attrs:{slot:"enterButton",icon:"search"},slot:"enterButton"},[e._v("选择")])],1)],1),a("a-form-item",{attrs:{label:"身份",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-radio-group",{on:{change:e.identityChange},model:{value:e.identity,callback:function(t){e.identity=t},expression:"identity"}},[a("a-radio",{attrs:{value:"1"}},[e._v("普通用户")]),a("a-radio",{attrs:{value:"2"}},[e._v("上级")])],1)],1),1==e.departIdShow?a("a-form-item",{attrs:{label:"负责部门",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-select",{staticStyle:{width:"100%"},attrs:{mode:"multiple",placeholder:"请选择负责部门",optionFilterProp:"children",getPopupContainer:function(e){return e.parentNode},dropdownStyle:{maxHeight:"200px",overflow:"auto"}},model:{value:e.departIds,callback:function(t){e.departIds=t},expression:"departIds"}},e._l(e.resultDepartOptions,(function(t){return a("a-select-option",{key:t.key,attrs:{value:t.key}},[e._v(e._s(t.title))])})),1)],1):e._e(),a("a-form-item",{attrs:{label:"头像",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("j-image-upload",{staticClass:"avatar-uploader",attrs:{text:"上传"},model:{value:e.fileList,callback:function(t){e.fileList=t},expression:"fileList"}})],1),a("a-form-item",{attrs:{label:"生日",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-date-picker",{directives:[{name:"decorator",rawName:"v-decorator",value:["birthday",{initialValue:e.model.birthday?e.moment(e.model.birthday,e.dateFormat):null}],expression:"['birthday', {initialValue:!model.birthday?null:moment(model.birthday,dateFormat)}]"}],staticStyle:{width:"100%"},attrs:{placeholder:"请选择生日"}})],1),a("a-form-item",{attrs:{label:"性别",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["sex",{}],expression:"[ 'sex', {}]"}],attrs:{placeholder:"请选择性别"}},[a("a-select-option",{attrs:{value:1}},[e._v("男")]),a("a-select-option",{attrs:{value:2}},[e._v("女")])],1)],1),a("a-form-item",{attrs:{label:"邮箱",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["email",e.validatorRules.email],expression:"[ 'email', validatorRules.email]"}],attrs:{placeholder:"请输入邮箱"}})],1),a("a-form-item",{attrs:{label:"手机号码",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["phone",e.validatorRules.phone],expression:"[ 'phone', validatorRules.phone]"}],attrs:{placeholder:"请输入手机号码",disabled:e.isDisabledAuth("user:form:phone")}})],1),a("a-form-item",{attrs:{label:"座机",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["telephone",e.validatorRules.telephone],expression:"[ 'telephone', validatorRules.telephone]"}],attrs:{placeholder:"请输入座机"}})],1),a("a-form-item",{attrs:{label:"工作流引擎",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("j-dict-select-tag",{directives:[{name:"decorator",rawName:"v-decorator",value:["activitiSync",{}],expression:"['activitiSync', {}]"}],attrs:{placeholder:"请选择是否同步工作流引擎",type:"radio",triggerChange:!0,dictCode:"activiti_sync"}})],1)],2)],1),a("depart-window",{ref:"departWindow",on:{ok:e.modalFormOk}}),a("div",{directives:[{name:"show",rawName:"v-show",value:!e.disableSubmit,expression:"!disableSubmit"}],staticClass:"drawer-bootom-button"},[a("a-popconfirm",{attrs:{title:"确定放弃编辑？",okText:"确定",cancelText:"取消"},on:{confirm:e.handleCancel}},[a("a-button",{staticStyle:{"margin-right":".8rem"}},[e._v("取消")])],1),a("a-button",{attrs:{type:"primary",loading:e.confirmLoading},on:{click:e.handleSubmit}},[e._v("提交")])],1)],2)},i=[],s=(a("3b2b"),a("28a5"),a("88bc")),l=a.n(s),o=a("c1df"),n=a.n(o),d=a("2b0e"),c=a("c63e"),u=a("61fc"),p=a("9fb0"),h=a("0fea"),f=a("4ec3");a("ac6a"),a("ac4d"),a("8a81"),a("5df3"),a("1c4c"),a("7f7f"),a("6b54"),a("2fdb"),a("6762");function m(e,t){var a;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(a=v(e))||t&&e&&"number"===typeof e.length){a&&(e=a);var r=0,i=function(){};return{s:i,n:function(){return r>=e.length?{done:!0}:{done:!1,value:e[r++]}},e:function(e){throw e},f:i}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var s,l=!0,o=!1;return{s:function(){a=e[Symbol.iterator]()},n:function(){var e=a.next();return l=e.done,e},e:function(e){o=!0,s=e},f:function(){try{l||null==a.return||a.return()}finally{if(o)throw s}}}}function v(e,t){if(e){if("string"===typeof e)return b(e,t);var a=Object.prototype.toString.call(e).slice(8,-1);return"Object"===a&&e.constructor&&(a=e.constructor.name),"Map"===a||"Set"===a?Array.from(e):"Arguments"===a||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(a)?b(e,t):void 0}}function b(e,t){(null==t||t>e.length)&&(t=e.length);for(var a=0,r=new Array(t);a<t;a++)r[a]=e[a];return r}function g(e,t){return!!y(e,t)||w(e)}function y(e,t){var a=[];try{if(!t)return!1;var r=t.permissionList;a=r.filter((function(e){return"2"==e.type}))}catch(u){}if(0==a.length)return!1;var i,s=[],l=m(a);try{for(l.s();!(i=l.n()).done;){var o=i.value;"2"==o.type&&s.push(o.action)}}catch(p){l.e(p)}finally{l.f()}if(!s.includes(e))return!1;var n,d=m(a);try{for(d.s();!(n=d.n()).done;){var c=n.value;if(e===c.action)return!0}}catch(p){d.e(p)}finally{d.f()}return!1}function w(e){var t,a=[],r=[],i=JSON.parse(sessionStorage.getItem(p["n"])||"[]"),s=m(i);try{for(s.s();!(t=s.n()).done;){var l=t.value;"2"==l.type&&a.push(l)}}catch(L){s.e(L)}finally{s.f()}var o,n=JSON.parse(sessionStorage.getItem(p["m"])||"[]"),d=m(n);try{for(d.s();!(o=d.n()).done;){var c=o.value;"2"==c.type&&r.push(c)}}catch(L){d.e(L)}finally{d.f()}var u=!1,h=!1;if(null!=r&&""!=r&&void 0!=r&&r.length>0){var f,v=m(r);try{for(v.s();!(f=v.n()).done;){var b=f.value;if(e===b.action){if("0"==b.status){h=!0;break}u=!0;break}}}catch(L){v.e(L)}finally{v.f()}}if(h)return!1;if(null===a||""===a||void 0===a||a.length<=0)return u;for(var g=[],y=0,w=a;y<w.length;y++){var C=w[y];"2"==C.type&&g.push(C.action)}if(g.includes(e)){var I,k=m(a);try{for(k.s();!(I=k.n()).done;){var D=I.value;e===D.action&&(u=!1)}}catch(L){k.e(L)}finally{k.f()}return u}return u}var C=a("e610"),I={name:"UserModal",components:{JImageUpload:C["default"],departWindow:c["default"],JSelectPosition:u["default"]},data:function(){return{departDisabled:!1,roleDisabled:!1,modalWidth:800,drawerWidth:700,modaltoggleFlag:!0,confirmDirty:!1,selectedDepartKeys:[],checkedDepartKeys:[],checkedDepartNames:[],checkedDepartNameString:"",resultDepartOptions:[],userId:"",disableSubmit:!1,userDepartModel:{userId:"",departIdList:[]},dateFormat:"YYYY-MM-DD",validatorRules:{username:{rules:[{required:!0,message:"请输入用户账号!"},{validator:this.validateUsername}]},password:{rules:[{required:!0,pattern:/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*()_+`\-={}:";'<>?,./]).{8,}$/,message:"密码由8位数字、大小写字母和特殊符号组成!"},{validator:this.validateToNextPassword}]},confirmpassword:{rules:[{required:!0,message:"请重新输入登陆密码!"},{validator:this.compareToFirstPassword}]},realname:{rules:[{required:!0,message:"请输入用户名称!"}]},phone:{rules:[{validator:this.validatePhone}]},email:{rules:[{validator:this.validateEmail}]},roles:{},workNo:{rules:[{required:!0,message:"请输入工号"},{validator:this.validateWorkNo}]},telephone:{rules:[{pattern:/^0\d{2,3}-[1-9]\d{6,7}$/,message:"请输入正确的座机号码"}]}},departIdShow:!1,departIds:[],title:"操作",visible:!1,model:{},roleList:[],selectedRole:[],labelCol:{xs:{span:24},sm:{span:5}},wrapperCol:{xs:{span:24},sm:{span:16}},uploadLoading:!1,confirmLoading:!1,headers:{},form:this.$form.createForm(this),picUrl:"",url:{fileUpload:window._CONFIG["domianURL"]+"/sys/common/upload",imgerver:window._CONFIG["staticDomainURL"],userWithDepart:"/sys/user/userDepartList",userId:"/sys/user/generateUserId",syncUserByUserName:"/process/extActProcess/doSyncUserByUserName"},identity:"1",fileList:[]}},created:function(){var e=d["default"].ls.get(p["a"]);this.headers={"X-Access-Token":e}},computed:{uploadAction:function(){return this.url.fileUpload}},methods:{isDisabledAuth:function(e){return g(e)},toggleScreen:function(){this.modaltoggleFlag?this.modalWidth=window.innerWidth:this.modalWidth=800,this.modaltoggleFlag=!this.modaltoggleFlag},initialRoleList:function(){var e=this;Object(f["O"])().then((function(t){t.success&&(e.roleList=t.result)}))},loadUserRoles:function(e){var t=this;Object(f["N"])({userid:e}).then((function(e){e.success&&(t.selectedRole=e.result)}))},refresh:function(){this.selectedDepartKeys=[],this.checkedDepartKeys=[],this.checkedDepartNames=[],this.checkedDepartNameString="",this.userId="",this.resultDepartOptions=[],this.departId=[],this.departIdShow=!1},add:function(){this.picUrl="",this.refresh(),this.edit({activitiSync:"1"})},edit:function(e){var t=this;this.resetScreenSize();var a=this;a.initialRoleList(),a.checkedDepartNameString="",a.form.resetFields(),e.hasOwnProperty("id")&&(a.loadUserRoles(e.id),setTimeout((function(){t.fileList=e.avatar}),5)),a.userId=e.id,a.visible=!0,a.model=Object.assign({},e),a.$nextTick((function(){a.form.setFieldsValue(l()(t.model,"username","sex","realname","email","phone","activitiSync","workNo","telephone","post"))})),"2"==this.model.identity?(this.identity="2",this.departIdShow=!0):(this.identity="1",this.departIdShow=!1),a.checkedDepartKeys=[],a.loadCheckedDeparts()},loadCheckedDeparts:function(){var e=this,t=this;t.userId&&Object(h["c"])(t.url.userWithDepart,{userId:t.userId}).then((function(a){if(t.checkedDepartNames=[],a.success){for(var r=[],i=[],s=0;s<a.result.length;s++)t.checkedDepartNames.push(a.result[s].title),e.checkedDepartNameString=e.checkedDepartNames.join(","),t.checkedDepartKeys.push(a.result[s].key),r.push({key:a.result[s].key,title:a.result[s].title}),i.push(a.result[s].key);t.resultDepartOptions=r,e.model.departIds?e.departIds=e.model.departIds.split(","):e.departIds=i,t.userDepartModel.departIdList=t.checkedDepartKeys}}))},close:function(){this.$emit("close"),this.visible=!1,this.disableSubmit=!1,this.selectedRole=[],this.userDepartModel={userId:"",departIdList:[]},this.checkedDepartNames=[],this.checkedDepartNameString="",this.checkedDepartKeys=[],this.selectedDepartKeys=[],this.resultDepartOptions=[],this.departIds=[],this.departIdShow=!1,this.identity="1",this.fileList=[]},moment:n.a,handleSubmit:function(){var e=this,t=this;this.form.validateFields((function(a,r){if(!a){t.confirmLoading=!0,r.birthday?r.birthday=r.birthday.format(e.dateFormat):r.birthday="";var i,s=Object.assign(e.model,r);s.avatar=t.fileList,s.selectedroles=e.selectedRole.length>0?e.selectedRole.join(","):"",s.selecteddeparts=e.userDepartModel.departIdList.length>0?e.userDepartModel.departIdList.join(","):"",s.identity=e.identity,"2"===e.identity?s.departIds=e.departIds.join(","):s.departIds="",e.model.id?i=Object(f["r"])(s):(s.id=e.userId,i=Object(f["e"])(s)),i.then((function(e){e.success?(t.$message.success(e.message),t.$emit("ok")):t.$message.warning(e.message)})).finally((function(){t.confirmLoading=!1,t.checkedDepartNames=[],t.userDepartModel.departIdList={userId:"",departIdList:[]},t.close()}))}}))},handleCancel:function(){this.close()},validateToNextPassword:function(e,t,a){var r=this.form,i=r.getFieldValue("confirmpassword");t&&i&&t!==i&&a("两次输入的密码不一样！"),t&&this.confirmDirty&&r.validateFields(["confirm"],{force:!0}),a()},compareToFirstPassword:function(e,t,a){var r=this.form;t&&t!==r.getFieldValue("password")?a("两次输入的密码不一样！"):a()},validatePhone:function(e,t,a){if(t)if(new RegExp(/^1[3|4|5|7|8|9][0-9]\d{8}$/).test(t)){var r={tableName:"sys_user",fieldName:"phone",fieldVal:t,dataId:this.userId};Object(f["m"])(r).then((function(e){e.success?a():a("手机号已存在!")}))}else a("请输入正确格式的手机号码!");else a()},validateEmail:function(e,t,a){if(t)if(new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/).test(t)){var r={tableName:"sys_user",fieldName:"email",fieldVal:t,dataId:this.userId};Object(f["m"])(r).then((function(e){e.success?a():a("邮箱已存在!")}))}else a("请输入正确格式的邮箱!");else a()},validateUsername:function(e,t,a){var r={tableName:"sys_user",fieldName:"username",fieldVal:t,dataId:this.userId};Object(f["m"])(r).then((function(e){e.success?a():a("用户名已存在!")}))},validateWorkNo:function(e,t,a){var r={tableName:"sys_user",fieldName:"work_no",fieldVal:t,dataId:this.userId};Object(f["m"])(r).then((function(e){e.success?a():a("工号已存在!")}))},handleConfirmBlur:function(e){var t=e.target.value;this.confirmDirty=this.confirmDirty||!!t},normFile:function(e){return Array.isArray(e)?e:e&&e.fileList},beforeUpload:function(e){var t=e.type;if(t.indexOf("image")<0)return this.$message.warning("请上传图片"),!1},handleChange:function(e){if(this.picUrl="","uploading"!==e.file.status){if("done"===e.file.status){var t=e.file.response;this.uploadLoading=!1,t.success?(this.model.avatar=t.message,this.picUrl="Has no pic url yet"):this.$message.warning(t.message)}}else this.uploadLoading=!0},onSearch:function(){this.$refs.departWindow.add(this.checkedDepartKeys,this.userId)},modalFormOk:function(e){this.checkedDepartNames=[],this.selectedDepartKeys=[],this.checkedDepartNameString="",this.userId=e.userId,this.userDepartModel.userId=e.userId,this.departIds=[],this.resultDepartOptions=[];for(var t=[],a=0;a<e.departIdList.length;a++)this.selectedDepartKeys.push(e.departIdList[a].key),this.checkedDepartNames.push(e.departIdList[a].title),this.checkedDepartNameString=this.checkedDepartNames.join(","),t.push({key:e.departIdList[a].key,title:e.departIdList[a].title}),this.departIds.push(e.departIdList[a].key);this.resultDepartOptions=t,this.userDepartModel.departIdList=this.selectedDepartKeys,this.checkedDepartKeys=this.selectedDepartKeys},resetScreenSize:function(){var e=document.body.clientWidth;this.drawerWidth=e<500?e:700},identityChange:function(e){"1"===e.target.value?this.departIdShow=!1:this.departIdShow=!0}}},k=I,D=(a("4004"),a("2877")),L=Object(D["a"])(k,r,i,!1,null,"05e6a5c0",null);t["default"]=L.exports},"61fc":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("j-select-biz-component",e._g(e._b({attrs:{width:1e3}},"j-select-biz-component",e.configs,!1),e.$listeners))},i=[],s=a("b296"),l={name:"JSelectPosition",components:{JSelectBizComponent:s["default"]},props:["value"],data:function(){return{settings:{name:"职务",displayKey:"name",returnKeys:["id","code"],listUrl:"/sys/position/list",queryParamCode:"name",queryParamText:"职务名称",columns:[{title:"职务名称",dataIndex:"name",align:"center",width:"30%",widthRight:"70%"},{title:"职务编码",dataIndex:"code",align:"center",width:"35%"},{title:"职级",dataIndex:"rank_dictText",align:"center",width:"25%"}]}}},computed:{configs:function(){return Object.assign({value:this.value},this.settings,this.$attrs)}}},o=l,n=a("2877"),d=Object(n["a"])(o,r,i,!1,null,"09d7ae7b",null);t["default"]=d.exports},"88bc":function(e,t,a){(function(t){var a=1/0,r=9007199254740991,i="[object Arguments]",s="[object Function]",l="[object GeneratorFunction]",o="[object Symbol]",n="object"==typeof t&&t&&t.Object===Object&&t,d="object"==typeof self&&self&&self.Object===Object&&self,c=n||d||Function("return this")();function u(e,t,a){switch(a.length){case 0:return e.call(t);case 1:return e.call(t,a[0]);case 2:return e.call(t,a[0],a[1]);case 3:return e.call(t,a[0],a[1],a[2])}return e.apply(t,a)}function p(e,t){var a=-1,r=e?e.length:0,i=Array(r);while(++a<r)i[a]=t(e[a],a,e);return i}function h(e,t){var a=-1,r=t.length,i=e.length;while(++a<r)e[i+a]=t[a];return e}var f=Object.prototype,m=f.hasOwnProperty,v=f.toString,b=c.Symbol,g=f.propertyIsEnumerable,y=b?b.isConcatSpreadable:void 0,w=Math.max;function C(e,t,a,r,i){var s=-1,l=e.length;a||(a=L),i||(i=[]);while(++s<l){var o=e[s];t>0&&a(o)?t>1?C(o,t-1,a,r,i):h(i,o):r||(i[i.length]=o)}return i}function I(e,t){return e=Object(e),k(e,t,(function(t,a){return a in e}))}function k(e,t,a){var r=-1,i=t.length,s={};while(++r<i){var l=t[r],o=e[l];a(o,l)&&(s[l]=o)}return s}function D(e,t){return t=w(void 0===t?e.length-1:t,0),function(){var a=arguments,r=-1,i=w(a.length-t,0),s=Array(i);while(++r<i)s[r]=a[t+r];r=-1;var l=Array(t+1);while(++r<t)l[r]=a[r];return l[t]=s,u(e,this,l)}}function L(e){return N(e)||S(e)||!!(y&&e&&e[y])}function x(e){if("string"==typeof e||A(e))return e;var t=e+"";return"0"==t&&1/e==-a?"-0":t}function S(e){return j(e)&&m.call(e,"callee")&&(!g.call(e,"callee")||v.call(e)==i)}var N=Array.isArray;function O(e){return null!=e&&F(e.length)&&!_(e)}function j(e){return U(e)&&O(e)}function _(e){var t=R(e)?v.call(e):"";return t==s||t==l}function F(e){return"number"==typeof e&&e>-1&&e%1==0&&e<=r}function R(e){var t=typeof e;return!!e&&("object"==t||"function"==t)}function U(e){return!!e&&"object"==typeof e}function A(e){return"symbol"==typeof e||U(e)&&v.call(e)==o}var $=D((function(e,t){return null==e?{}:I(e,p(C(t,1),x))}));e.exports=$}).call(this,a("c8ba"))},c298:function(e,t,a){"use strict";a("c77d")},c63e:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{width:e.modalWidth,visible:e.visible,title:"部门搜索",confirmLoading:e.confirmLoading,cancelText:"关闭",wrapClassName:"ant-modal-cust-warp"},on:{ok:e.handleSubmit,cancel:e.handleCancel}},[[a("a-form",{attrs:{form:e.form}},[a("a-form-item",{attrs:{labelCol:e.labelCol,wrapperCol:e.wrapperCol,label:"上级部门"}},[a("a-tree",{attrs:{multiple:"",treeCheckable:"tree",checkable:"",checkedKeys:e.checkedKeys,allowClear:"true",checkStrictly:!0,dropdownStyle:{maxHeight:"200px",overflow:"auto"},treeData:e.departTree,placeholder:"请选择上级部门"},on:{check:e.onCheck}})],1)],1)]],2)},i=[],s=a("88bc"),l=a.n(s),o=a("0fea"),n=a("4ec3"),d=a("418f"),c={name:"DepartWindow",components:{userModal:d["default"]},data:function(){return{checkedKeys:[],userId:"",model:{},userDepartModel:{userId:"",departIdList:[]},departList:[],modalWidth:400,departTree:[],title:"操作",visible:!1,labelCol:{xs:{span:24},sm:{span:5}},wrapperCol:{xs:{span:24},sm:{span:16}},confirmLoading:!1,headers:{},form:this.$form.createForm(this),url:{userId:"/sys/user/generateUserId"}}},methods:{add:function(e,t){this.checkedKeys=e,this.userId=t,this.edit({})},edit:function(e){var t=this;this.departList=[],this.queryDepartTree(),this.form.resetFields(),this.visible=!0,this.model=Object.assign({},e);var a=l()(this.model,"id","userId","departIdList");this.$nextTick((function(){t.form.setFieldsValue(a)}))},close:function(){this.$emit("close"),this.visible=!1,this.departList=[],this.checkedKeys=[]},handleSubmit:function(){var e=this,t=this;this.form.validateFields((function(a){if(!a)if(t.confirmLoading=!0,null==e.userId)Object(o["c"])(e.url.userId).then((function(a){if(a.success){var r={userId:a.result,departIdList:e.departList};t.$emit("ok",r)}})).finally((function(){t.departList=[],t.confirmLoading=!1,t.close()}));else{var r={userId:e.userId,departIdList:e.departList};t.departList=[],t.$emit("ok",r),t.confirmLoading=!1,t.close()}}))},handleCancel:function(){this.close()},onCheck:function(e,t){this.departList=[],this.checkedKeys=e.checked;for(var a=t.checkedNodes,r=0;r<a.length;r++){var i=a[r].data.props,s={key:"",value:"",title:""};s.key=i.value,s.value=i.value,s.title=i.title,this.departList.push(s)}},queryDepartTree:function(){var e=this;Object(n["E"])().then((function(t){t.success&&(e.departTree=t.result)}))},modalFormOk:function(){}}},u=c,p=(a("c298"),a("2877")),h=Object(p["a"])(u,r,i,!1,null,"214a8dc7",null);t["default"]=h.exports},c77d:function(e,t,a){},e610:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-upload",{attrs:{name:"file",listType:"picture-card",multiple:e.isMultiple,action:e.uploadAction,headers:e.headers,data:{biz:e.bizPath},fileList:e.fileList,beforeUpload:e.beforeUpload,disabled:e.disabled,isMultiple:e.isMultiple,showUploadList:e.isMultiple},on:{change:e.handleChange,preview:e.handlePreview}},[!e.isMultiple&&e.picUrl?a("img",{staticStyle:{height:"104px","max-width":"300px"},attrs:{src:e.getAvatarView()}}):a("div",[a("a-icon",{attrs:{type:e.uploadLoading?"loading":"plus"}}),a("div",{staticClass:"ant-upload-text"},[e._v(e._s(e.text))])],1),a("a-modal",{attrs:{visible:e.previewVisible,footer:null},on:{cancel:function(t){return e.handleCancel()}}},[a("img",{staticStyle:{width:"100%"},attrs:{alt:"example",src:e.previewImage}})])],1)},i=[],s=(a("7f7f"),a("28a5"),a("a481"),a("3b2b"),a("2b0e")),l=a("9fb0"),o=a("0fea"),n=function(){return"-"+parseInt(1e4*Math.random()+1,10)},d=function(e){if(e.lastIndexOf("\\")>=0){var t=new RegExp("\\\\","g");e=e.replace(t,"/")}return e.substring(e.lastIndexOf("/")+1)},c={name:"JImageUpload",data:function(){return{uploadAction:window._CONFIG["domianURL"]+"/sys/common/upload",urlView:window._CONFIG["staticDomainURL"],uploadLoading:!1,picUrl:!1,headers:{},fileList:[],previewImage:"",previewVisible:!1}},props:{text:{type:String,required:!1,default:"上传"},bizPath:{type:String,required:!1,default:"temp"},value:{type:[String,Array],required:!1},disabled:{type:Boolean,required:!1,default:!1},isMultiple:{type:Boolean,required:!1,default:!1}},watch:{value:function(e){e instanceof Array?this.initFileList(e.join(",")):this.initFileList(e)}},created:function(){var e=s["default"].ls.get(l["a"]);this.headers={"X-Access-Token":e}},methods:{initFileList:function(e){if(e&&0!=e.length){this.picUrl=!0;for(var t=[],a=e.split(","),r=0;r<a.length;r++){var i=Object(o["d"])(a[r],this.urlView,"http");t.push({uid:n(),name:d(a[r]),status:"done",url:i,response:{status:"history",message:a[r]}})}this.fileList=t}else this.fileList=[]},beforeUpload:function(e){var t=e.type;if(t.indexOf("image")<0)return this.$message.warning("请上传图片"),!1},handleChange:function(e){this.picUrl=!1;var t=e.fileList;"done"===e.file.status?e.file.response.success&&(this.picUrl=!0,t=t.map((function(e){return e.response&&(e.url=e.response.message),e}))):"error"===e.file.status?this.$message.error("".concat(e.file.name," 上传失败.")):"removed"===e.file.status&&this.handleDelete(e.file),this.fileList=t,"done"!==e.file.status&&"removed"!==e.file.status||this.handlePathChange()},handlePreview:function(e){this.previewImage=e.url||e.thumbUrl,this.previewVisible=!0},getAvatarView:function(){if(this.fileList.length>0){var e=this.fileList[0].url;return Object(o["d"])(e,this.urlView,"http")}},handlePathChange:function(){var e=this.fileList,t="";e&&0!=e.length||(t="");var a=[];if(this.isMultiple)for(var r=0;r<e.length;r++)a.push(e[r].response.message);else a.push(e[e.length-1].response.message);a.length>0&&(t=a.join(",")),this.$emit("change",t)},handleDelete:function(e){},handleCancel:function(){this.close(),this.previewVisible=!1},close:function(){}},model:{prop:"value",event:"change"}},u=c,p=a("2877"),h=Object(p["a"])(u,r,i,!1,null,"07822c64",null);t["default"]=h.exports},f721:function(e,t,a){}}]);