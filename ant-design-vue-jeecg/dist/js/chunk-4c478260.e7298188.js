(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4c478260"],{3335:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{title:e.title,width:1200,visible:e.visible,confirmLoading:e.confirmLoading,cancelText:"关闭"},on:{ok:e.handleOk,cancel:e.handleCancel}},[a("a-spin",{attrs:{spinning:e.confirmLoading}},[a("a-form",{attrs:{form:e.form}},[a("a-card",{staticClass:"card",attrs:{bordered:!1}},[a("a-row",{staticClass:"form-row",attrs:{gutter:16}},[a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"任务名"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.name",{rules:[{required:!0,message:"请输入任务名称",whitespace:!0}]}],expression:"[ 'task.name', {rules: [{ required: true, message: '请输入任务名称', whitespace: true}]} ]"}],attrs:{placeholder:"请输入任务名称"}})],1)],1),a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"任务描述"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.description",{rules:[{required:!0,message:"请输入任务描述",whitespace:!0}]}],expression:"['task.description', {rules: [{ required: true, message: '请输入任务描述', whitespace: true}]} ]"}],attrs:{placeholder:"请输入任务描述"}})],1)],1),a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"执行人"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.executor",{rules:[{required:!0,message:"请选择执行人"}]}],expression:"['task.executor',{rules: [{ required: true, message: '请选择执行人'}]}  ]"}],attrs:{placeholder:"请选择执行人"}},[a("a-select-option",{attrs:{value:"黄丽丽"}},[e._v("黄丽丽")]),a("a-select-option",{attrs:{value:"李大刀"}},[e._v("李大刀")])],1)],1)],1)],1),a("a-row",{staticClass:"form-row",attrs:{gutter:16}},[a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"责任人"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.manager",{rules:[{required:!0,message:"请选择责任人"}]}],expression:"['task.manager',  {rules: [{ required: true, message: '请选择责任人'}]} ]"}],attrs:{placeholder:"请选择责任人"}},[a("a-select-option",{attrs:{value:"王伟"}},[e._v("王伟")]),a("a-select-option",{attrs:{value:"李红军"}},[e._v("李红军")])],1)],1)],1),a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"提醒时间"}},[a("a-time-picker",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.time",{rules:[{required:!0,message:"请选择提醒时间"}]}],expression:"['task.time', {rules: [{ required: true, message: '请选择提醒时间'}]} ]"}],staticStyle:{width:"100%"}})],1)],1),a("a-col",{attrs:{lg:8}},[a("a-form-item",{attrs:{label:"任务类型"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["task.type",{rules:[{required:!0,message:"请选择任务类型"}]}],expression:"['task.type', {rules: [{ required: true, message: '请选择任务类型'}]} ]"}],attrs:{placeholder:"请选择任务类型"}},[a("a-select-option",{attrs:{value:"定时执行"}},[e._v("定时执行")]),a("a-select-option",{attrs:{value:"周期执行"}},[e._v("周期执行")])],1)],1)],1)],1)],1),a("a-tabs",{attrs:{defaultActiveKey:"1"}},[a("a-tab-pane",{key:"1",attrs:{tab:"Tab 1"}},[a("a-table",{attrs:{columns:e.columns,dataSource:e.data,pagination:!1,size:"middle"},scopedSlots:e._u([e._l(["name","workId","department"],(function(t,r){return{key:t,fn:function(n,i,o){return[a("a-tooltip",{attrs:{title:"必填项",defaultVisible:!1,overlayStyle:"{ color: 'red' }"}},[i.editable?a("a-input",{key:t,staticStyle:{margin:"-5px 0"},attrs:{value:n,placeholder:e.columns[r].title},on:{change:function(a){return e.handlerRowChange(a.target.value,i.key,t)}}}):[e._v(e._s(n))]],2)]}}})),{key:"operation",fn:function(t,r,n){return[r.editable?[r.isNew?a("span",[a("a",{on:{click:function(t){return e.saveRow(r.key)}}},[e._v("添加")]),a("a-divider",{attrs:{type:"vertical"}}),a("a-popconfirm",{attrs:{title:"是否要删除此行？"},on:{confirm:function(t){return e.removeRow(r.key)}}},[a("a",[e._v("删除")])])],1):a("span",[a("a",{on:{click:function(t){return e.saveRow(r.key)}}},[e._v("保存")]),a("a-divider",{attrs:{type:"vertical"}}),a("a",{on:{click:function(t){return e.cancelEditRow(r.key)}}},[e._v("取消")])],1)]:a("span",[a("a",{on:{click:function(t){return e.editRow(r.key)}}},[e._v("编辑")]),a("a-divider",{attrs:{type:"vertical"}}),a("a-popconfirm",{attrs:{title:"是否要删除此行？"},on:{confirm:function(t){return e.removeRow(r.key)}}},[a("a",[e._v("删除")])])],1)]}}],null,!0)}),a("a-button",{staticStyle:{width:"100%","margin-top":"16px","margin-bottom":"8px"},attrs:{type:"dashed",icon:"plus"},on:{click:e.newRow}},[e._v("新增成员")])],1),a("a-tab-pane",{key:"2",attrs:{tab:"Tab 2",forceRender:""}},[e._v("\n          Content of Tab Pane 2\n        ")]),a("a-tab-pane",{key:"3",attrs:{tab:"Tab 3"}},[e._v("Content of Tab Pane 3")])],1)],1)],1)],1)},n=[],i=a("2909"),o=(a("6b54"),a("0fea")),s=a("88bc"),l=a.n(s),c=a("c1df"),u=a.n(c),d={name:"JeecgDemoTabsModal",data:function(){return{title:"操作",visible:!1,model:{},columns:[{title:"成员姓名",dataIndex:"name",key:"name",width:"20%",scopedSlots:{customRender:"name"}},{title:"工号",dataIndex:"workId",key:"workId",width:"20%",scopedSlots:{customRender:"workId"}},{title:"所属部门",dataIndex:"department",key:"department",width:"40%",scopedSlots:{customRender:"department"}},{title:"操作",key:"action",scopedSlots:{customRender:"operation"}}],data:[{key:"1",name:"小明",workId:"001",editable:!1,department:"行政部"},{key:"2",name:"李莉",workId:"002",editable:!1,department:"IT部"},{key:"3",name:"王小帅",workId:"003",editable:!1,department:"财务部"}],confirmLoading:!1,form:this.$form.createForm(this),validatorRules:{},url:{add:"/test/jeecgDemo/add",edit:"/test/jeecgDemo/edit"}}},created:function(){},methods:{add:function(){this.edit({})},edit:function(e){var t=this;this.form.resetFields(),this.model=Object.assign({},e),this.visible=!0,this.$nextTick((function(){t.form.setFieldsValue(l()(t.model,"name","keyWord","sex","age","email","content")),t.form.setFieldsValue({punchTime:t.model.punchTime?u()(t.model.punchTime,"YYYY-MM-DD HH:mm:ss"):null}),t.form.setFieldsValue({birthday:t.model.birthday?u()(t.model.birthday):null})}))},close:function(){this.$emit("close"),this.visible=!1},handleOk:function(){var e=this,t=this;this.form.validateFields((function(a,r){if(!a){t.confirmLoading=!0;var n="",i="";e.model.id?(n+=e.url.edit,i="put"):(n+=e.url.add,i="post");var s=Object.assign(e.model,r);s.punchTime=s.punchTime?s.punchTime.format("YYYY-MM-DD HH:mm:ss"):null,s.birthday=s.birthday?s.birthday.format():null,Object(o["h"])(n,s,i).then((function(e){e.success?(t.$message.success(e.message),t.$emit("ok")):t.$message.warning(e.message)})).finally((function(){t.confirmLoading=!1,t.close()}))}}))},handleCancel:function(){this.close()},newRow:function(){var e=Math.round((new Date).getTime()).toString();this.data.push({key:e,name:"",workId:"",department:"",editable:!0,isNew:!0})},removeRow:function(e){var t=this.data.filter((function(t){return t.key!==e}));this.data=t},saveRow:function(e){var t=this.data.filter((function(t){return t.key===e}))[0];t.editable=!1,t.isNew=!1},handlerRowChange:function(e,t,a){var r=Object(i["a"])(this.data),n=r.filter((function(e){return t===e.key}))[0];n&&(n[a]=e,this.data=r)},editRow:function(e){var t=this.data.filter((function(t){return t.key===e}))[0];t.editable=!t.editable},cancelEditRow:function(e){var t=this.data.filter((function(t){return t.key===e}))[0];t.editable=!1}}},m=d,f=(a("3517"),a("2877")),p=Object(f["a"])(m,r,n,!1,null,"e1837066",null);t["default"]=p.exports},3517:function(e,t,a){"use strict";a("7ca6")},"7ca6":function(e,t,a){},"88bc":function(e,t,a){(function(t){var a=1/0,r=9007199254740991,n="[object Arguments]",i="[object Function]",o="[object GeneratorFunction]",s="[object Symbol]",l="object"==typeof t&&t&&t.Object===Object&&t,c="object"==typeof self&&self&&self.Object===Object&&self,u=l||c||Function("return this")();function d(e,t,a){switch(a.length){case 0:return e.call(t);case 1:return e.call(t,a[0]);case 2:return e.call(t,a[0],a[1]);case 3:return e.call(t,a[0],a[1],a[2])}return e.apply(t,a)}function m(e,t){var a=-1,r=e?e.length:0,n=Array(r);while(++a<r)n[a]=t(e[a],a,e);return n}function f(e,t){var a=-1,r=t.length,n=e.length;while(++a<r)e[n+a]=t[a];return e}var p=Object.prototype,v=p.hasOwnProperty,h=p.toString,b=u.Symbol,y=p.propertyIsEnumerable,g=b?b.isConcatSpreadable:void 0,w=Math.max;function k(e,t,a,r,n){var i=-1,o=e.length;a||(a=R),n||(n=[]);while(++i<o){var s=e[i];t>0&&a(s)?t>1?k(s,t-1,a,r,n):f(n,s):r||(n[n.length]=s)}return n}function j(e,t){return e=Object(e),_(e,t,(function(t,a){return a in e}))}function _(e,t,a){var r=-1,n=t.length,i={};while(++r<n){var o=t[r],s=e[o];a(s,o)&&(i[o]=s)}return i}function x(e,t){return t=w(void 0===t?e.length-1:t,0),function(){var a=arguments,r=-1,n=w(a.length-t,0),i=Array(n);while(++r<n)i[r]=a[t+r];r=-1;var o=Array(t+1);while(++r<t)o[r]=a[r];return o[t]=i,d(e,this,o)}}function R(e){return O(e)||S(e)||!!(g&&e&&e[g])}function T(e){if("string"==typeof e||Y(e))return e;var t=e+"";return"0"==t&&1/e==-a?"-0":t}function S(e){return q(e)&&v.call(e,"callee")&&(!y.call(e,"callee")||h.call(e)==n)}var O=Array.isArray;function I(e){return null!=e&&F(e.length)&&!C(e)}function q(e){return D(e)&&I(e)}function C(e){var t=N(e)?h.call(e):"";return t==i||t==o}function F(e){return"number"==typeof e&&e>-1&&e%1==0&&e<=r}function N(e){var t=typeof e;return!!e&&("object"==t||"function"==t)}function D(e){return!!e&&"object"==typeof e}function Y(e){return"symbol"==typeof e||D(e)&&h.call(e)==s}var A=x((function(e,t){return null==e?{}:j(e,m(k(t,1),T))}));e.exports=A}).call(this,a("c8ba"))}}]);