(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-49a42fe2","chunk-0a7ef495","chunk-2d0b1e33","chunk-2d0b39b0","chunk-60ddc974","chunk-2d0b39b0","chunk-2d0b39b0"],{"0025":function(e,t,a){},2285:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-drawer",{attrs:{title:"数据规则/按钮权限配置",width:"365",closable:!1,visible:e.visible},on:{close:e.onClose}},[a("a-tabs",{attrs:{defaultActiveKey:"1"}},[a("a-tab-pane",{key:"1",attrs:{tab:"数据规则"}},[e.dataruleList.length>0?a("a-checkbox-group",{model:{value:e.dataruleChecked,callback:function(t){e.dataruleChecked=t},expression:"dataruleChecked"}},[a("a-row",[e._l(e.dataruleList,(function(t,s){return a("a-col",{key:"dr"+s,attrs:{span:24}},[a("a-checkbox",{attrs:{value:t.id}},[e._v(e._s(t.ruleName))])],1)})),a("a-col",{attrs:{span:24}},[a("div",{staticStyle:{width:"100%","margin-top":"15px"}},[a("a-button",{attrs:{type:"primary",size:"small",icon:"save"},on:{click:e.saveDataruleForRole}},[e._v("点击保存")])],1)])],2)],1):a("div",[a("h3",[e._v("无配置信息!")])])],1)],1)],1)},i=[],n=(a("28a5"),a("290c")),c=a("da05"),l=a("0fea"),r={name:"RoleDataruleModal",components:{ACol:c["b"],ARow:n["a"]},data:function(){return{functionId:"",roleId:"",visible:!1,tabList:[{key:"1",tab:"数据规则"},{key:"2",tab:"按钮权限"}],activeTabKey:"1",url:{datarule:"/sys/role/datarule"},dataruleList:[],dataruleChecked:[]}},methods:{loadData:function(){var e=this;Object(l["c"])("".concat(this.url.datarule,"/").concat(this.functionId,"/").concat(this.roleId)).then((function(t){if(t.success){e.dataruleList=t.result.datarule;var a=t.result.drChecked;a&&(e.dataruleChecked=a.split(","))}}))},saveDataruleForRole:function(){var e=this;this.dataruleChecked&&0!=this.dataruleChecked.length||this.$message.warning("请注意，现未勾选任何数据权限!");var t={permissionId:this.functionId,roleId:this.roleId,dataRuleIds:this.dataruleChecked.join(",")};Object(l["i"])(this.url.datarule,t).then((function(t){t.success?e.$message.success(t.message):e.$message.error(t.message)}))},show:function(e,t){this.onReset(),this.functionId=e,this.roleId=t,this.visible=!0,this.loadData()},onClose:function(){this.visible=!1,this.onReset()},onTabChange:function(e){this.activeTabKey=e},onReset:function(){this.functionId="",this.roleId="",this.dataruleList=[],this.dataruleChecked=[]}}},o=r,u=a("2877"),d=Object(u["a"])(o,s,i,!1,null,"5fa38486",null);t["default"]=d.exports},"28a5":function(e,t,a){"use strict";var s=a("aae3"),i=a("cb7c"),n=a("ebd6"),c=a("0390"),l=a("9def"),r=a("5f1b"),o=a("520a"),u=a("79e5"),d=Math.min,h=[].push,f="split",k="length",y="lastIndex",p=4294967295,v=!u((function(){RegExp(p,"y")}));a("214f")("split",2,(function(e,t,a,u){var b;return b="c"=="abbc"[f](/(b)*/)[1]||4!="test"[f](/(?:)/,-1)[k]||2!="ab"[f](/(?:ab)*/)[k]||4!="."[f](/(.?)(.?)/)[k]||"."[f](/()()/)[k]>1||""[f](/.?/)[k]?function(e,t){var i=String(this);if(void 0===e&&0===t)return[];if(!s(e))return a.call(i,e,t);var n,c,l,r=[],u=(e.ignoreCase?"i":"")+(e.multiline?"m":"")+(e.unicode?"u":"")+(e.sticky?"y":""),d=0,f=void 0===t?p:t>>>0,v=new RegExp(e.source,u+"g");while(n=o.call(v,i)){if(c=v[y],c>d&&(r.push(i.slice(d,n.index)),n[k]>1&&n.index<i[k]&&h.apply(r,n.slice(1)),l=n[0][k],d=c,r[k]>=f))break;v[y]===n.index&&v[y]++}return d===i[k]?!l&&v.test("")||r.push(""):r.push(i.slice(d)),r[k]>f?r.slice(0,f):r}:"0"[f](void 0,0)[k]?function(e,t){return void 0===e&&0===t?[]:a.call(this,e,t)}:a,[function(a,s){var i=e(this),n=void 0==a?void 0:a[t];return void 0!==n?n.call(a,i,s):b.call(String(i),a,s)},function(e,t){var s=u(b,e,this,t,b!==a);if(s.done)return s.value;var o=i(e),h=String(this),f=n(o,RegExp),k=o.unicode,y=(o.ignoreCase?"i":"")+(o.multiline?"m":"")+(o.unicode?"u":"")+(v?"y":"g"),m=new f(v?o:"^(?:"+o.source+")",y),g=void 0===t?p:t>>>0;if(0===g)return[];if(0===h.length)return null===r(m,h)?[h]:[];var x=0,K=0,C=[];while(K<h.length){m.lastIndex=v?K:0;var w,I=r(m,v?h:h.slice(K));if(null===I||(w=d(l(m.lastIndex+(v?0:K)),h.length))===x)K=c(h,K,k);else{if(C.push(h.slice(x,K)),C.length===g)return C;for(var S=1;S<=I.length-1;S++)if(C.push(I[S]),C.length===g)return C;K=x=w}}return C.push(h.slice(x)),C}]}))},9410:function(e,t,a){"use strict";a("0025")},ee18:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-drawer",{staticStyle:{height:"calc(100% - 55px)",overflow:"auto","padding-bottom":"53px"},attrs:{title:e.title,maskClosable:!0,width:"650",placement:"right",closable:!0,visible:e.visible},on:{close:e.close}},[a("a-form",[a("a-form-item",{attrs:{label:"所拥有的权限"}},[a("a-tree",{attrs:{checkable:"",checkedKeys:e.checkedKeys,treeData:e.treeData,selectedKeys:e.selectedKeys,expandedKeys:e.expandedKeysss,checkStrictly:e.checkStrictly},on:{check:e.onCheck,expand:e.onExpand,select:e.onTreeNodeSelect},scopedSlots:e._u([{key:"hasDatarule",fn:function(t){var s=t.slotTitle,i=t.ruleFlag;return a("span",{},[e._v("\n          "+e._s(s)),i?a("a-icon",{staticStyle:{"margin-left":"5px",color:"red"},attrs:{type:"align-left"}}):e._e()],1)}}])})],1)],1),a("div",{staticClass:"drawer-bootom-button"},[a("a-dropdown",{staticStyle:{float:"left"},attrs:{trigger:["click"],placement:"topCenter"}},[a("a-menu",{attrs:{slot:"overlay"},slot:"overlay"},[a("a-menu-item",{key:"1",on:{click:function(t){return e.switchCheckStrictly(1)}}},[e._v("父子关联")]),a("a-menu-item",{key:"2",on:{click:function(t){return e.switchCheckStrictly(2)}}},[e._v("取消关联")]),a("a-menu-item",{key:"3",on:{click:e.checkALL}},[e._v("全部勾选")]),a("a-menu-item",{key:"4",on:{click:e.cancelCheckALL}},[e._v("取消全选")]),a("a-menu-item",{key:"5",on:{click:e.expandAll}},[e._v("展开所有")]),a("a-menu-item",{key:"6",on:{click:e.closeAll}},[e._v("合并所有")])],1),a("a-button",[e._v("\n        树操作 "),a("a-icon",{attrs:{type:"up"}})],1)],1),a("a-popconfirm",{attrs:{title:"确定放弃编辑？",okText:"确定",cancelText:"取消"},on:{confirm:e.close}},[a("a-button",{staticStyle:{"margin-right":".8rem"}},[e._v("取消")])],1),a("a-button",{staticStyle:{"margin-right":"0.8rem"},attrs:{type:"primary",loading:e.loading,ghost:""},on:{click:function(t){return e.handleSubmit(!1)}}},[e._v("仅保存")]),a("a-button",{attrs:{type:"primary",loading:e.loading},on:{click:function(t){return e.handleSubmit(!0)}}},[e._v("保存并关闭")])],1),a("role-datarule-modal",{ref:"datarule"})],1)},i=[],n=a("2909"),c=a("4ec3"),l=a("2285"),r={name:"RoleModal",components:{RoleDataruleModal:l["default"]},data:function(){return{roleId:"",treeData:[],defaultCheckedKeys:[],checkedKeys:[],expandedKeysss:[],allTreeKeys:[],autoExpandParent:!0,checkStrictly:!0,title:"角色权限配置",visible:!1,loading:!1,selectedKeys:[]}},methods:{onTreeNodeSelect:function(e){e&&e.length>0&&(this.selectedKeys=e),this.$refs.datarule.show(this.selectedKeys[0],this.roleId)},onCheck:function(e){this.checkStrictly?this.checkedKeys=e.checked:this.checkedKeys=e},show:function(e){this.roleId=e,this.visible=!0},close:function(){this.reset(),this.$emit("close"),this.visible=!1},onExpand:function(e){this.expandedKeysss=e,this.autoExpandParent=!1},reset:function(){this.expandedKeysss=[],this.checkedKeys=[],this.defaultCheckedKeys=[],this.loading=!1},expandAll:function(){this.expandedKeysss=this.allTreeKeys},closeAll:function(){this.expandedKeysss=[]},checkALL:function(){this.checkedKeys=this.allTreeKeys},cancelCheckALL:function(){this.checkedKeys=[]},switchCheckStrictly:function(e){1==e?this.checkStrictly=!1:2==e&&(this.checkStrictly=!0)},handleCancel:function(){this.close()},handleSubmit:function(e){var t=this,a=this,s={roleId:a.roleId,permissionIds:a.checkedKeys.join(","),lastpermissionIds:a.defaultCheckedKeys.join(",")};a.loading=!0,Object(c["R"])(s).then((function(s){s.success?(a.$message.success(s.message),a.loading=!1,e&&a.close()):(a.$message.error(s.message),a.loading=!1,e&&a.close()),t.loadData()}))},loadData:function(){var e=this;Object(c["L"])().then((function(t){e.treeData=t.result.treeList,e.allTreeKeys=t.result.ids,Object(c["I"])({roleId:e.roleId}).then((function(t){e.checkedKeys=Object(n["a"])(t.result),e.defaultCheckedKeys=Object(n["a"])(t.result),e.expandedKeysss=e.allTreeKeys}))}))}},watch:{visible:function(){this.visible&&this.loadData()}}},o=r,u=(a("9410"),a("2877")),d=Object(u["a"])(o,s,i,!1,null,"4f6f2062",null);t["default"]=d.exports}}]);