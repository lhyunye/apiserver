(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4d3747a6","chunk-2d238446","chunk-2d0df843"],{"89f2":function(e,t,a){"use strict";a.d(t,"c",(function(){return u})),a.d(t,"a",(function(){return s})),a.d(t,"b",(function(){return d}));a("ac4d"),a("8a81"),a("5df3"),a("1c4c"),a("7f7f"),a("96cf"),a("ac6a"),a("28a5"),a("6b54");var n=a("1da1"),l=a("4ec3");a("0fea");function r(e,t){var a;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(a=i(e))||t&&e&&"number"===typeof e.length){a&&(e=a);var n=0,l=function(){};return{s:l,n:function(){return n>=e.length?{done:!0}:{done:!1,value:e[n++]}},e:function(e){throw e},f:l}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var r,o=!0,u=!1;return{s:function(){a=e[Symbol.iterator]()},n:function(){var e=a.next();return o=e.done,e},e:function(e){u=!0,r=e},f:function(){try{o||null==a.return||a.return()}finally{if(u)throw r}}}}function i(e,t){if(e){if("string"===typeof e)return o(e,t);var a=Object.prototype.toString.call(e).slice(8,-1);return"Object"===a&&e.constructor&&(a=e.constructor.name),"Map"===a||"Set"===a?Array.from(e):"Arguments"===a||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(a)?o(e,t):void 0}}function o(e,t){(null==t||t>e.length)&&(t=e.length);for(var a=0,n=new Array(t);a<t;a++)n[a]=e[a];return n}function u(e){return c.apply(this,arguments)}function c(){return c=Object(n["a"])(regeneratorRuntime.mark((function e(t){var a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t){e.next=2;break}return e.abrupt("return","字典Code不能为空!");case 2:return e.next=4,Object(l["f"])(t);case 4:return a=e.sent,e.abrupt("return",a);case 6:case"end":return e.stop()}}),e)}))),c.apply(this,arguments)}function s(e,t){if(e instanceof Array){var a,n=r(e);try{for(n.s();!(a=n.n()).done;){var l=a.value;if(t===l.value)return l.text}}catch(i){n.e(i)}finally{n.f()}}return t}function d(e,t){if(0===t||"0"===t){var a,n=r(e);try{for(n.s();!(a=n.n()).done;){var l=a.value;if(t==l.value)return l.text}}catch(u){n.e(u)}finally{n.f()}}if(!t||!e||0==e.length)return"";var i="";t=t.toString();var o=t.split(",");return e.forEach((function(e){for(var t=0;t<o.length;t++)if(o[t]===e.value){i+=e.text+",";break}})),""==i?t:i.substring(0,i.length-1)}},ff3c:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("a-button",{attrs:{type:"primary"},on:{click:e.handleTableCheck}},[e._v("表单验证")]),a("span",{staticStyle:{"padding-left":"8px"}}),a("a-tooltip",{attrs:{placement:"top",title:"获取值，忽略表单验证",autoAdjustOverflow:!0}},[a("a-button",{attrs:{type:"primary"},on:{click:e.handleTableGet}},[e._v("获取值")])],1),a("span",{staticStyle:{"padding-left":"8px"}}),a("a-tooltip",{attrs:{placement:"top",title:"模拟加载1000条数据",autoAdjustOverflow:!0}},[a("a-button",{attrs:{type:"primary"},on:{click:e.handleTableSet}},[e._v("设置值")])],1),a("j-editable-table",{ref:"editableTable",staticStyle:{"margin-top":"8px"},attrs:{loading:e.loading,columns:e.columns,dataSource:e.dataSource,rowNumber:!0,rowSelection:!0,actionButton:!0,dragSort:!0},on:{selectRowChange:e.handleSelectRowChange},scopedSlots:e._u([{key:"action",fn:function(t){return[a("a",{on:{click:function(a){return e.handleDelete(t)}}},[e._v(e._s(t.text))])]}}])})],1)},l=[],r=a("c1df"),i=a.n(r),o=a("e2e0"),u=a("ca00"),c=a("7550"),s={name:"DefaultTable",components:{JEditableTable:c["default"]},data:function(){return{loading:!1,columns:[{title:"字段名称",key:"dbFieldName",width:"300px",type:o["a"].input,defaultValue:"",placeholder:"请输入${title}",validateRules:[{required:!0,message:"请输入${title}"},{pattern:/^[a-z|A-Z][a-z|A-Z\d_-]{0,}$/,message:"${title}必须以字母开头，可包含数字、下划线、横杠"},{unique:!0,message:"${title}不能重复"},{handler:function(e,t,a,n,l,r){"blur"===e&&"abc"===t?l(!1,"${title}不能是abc"):l(!0)},message:"${title}默认提示"}]},{title:"文件域",key:"upload",type:o["a"].upload,width:"300px",placeholder:"点击上传",token:!0,responseName:"message",action:window._CONFIG["domianURL"]+"/sys/common/upload"},{title:"字段类型",key:"dbFieldType",width:"300px",type:o["a"].select,options:[{title:"String",value:"string"},{title:"Integer",value:"int"},{title:"Double",value:"double"},{title:"Boolean",value:"boolean"}],allowInput:!0,defaultValue:"",placeholder:"请选择${title}",validateRules:[{required:!0,message:"请选择${title}"}]},{title:"性别（字典）",key:"sex_dict",width:"300px",type:o["a"].select,options:[],dictCode:"sex",placeholder:"请选择${title}",validateRules:[{required:!0,message:"请选择${title}"}]},{title:"多选测试",key:"multipleSelect",width:"300px",type:o["a"].select,props:{mode:"multiple"},options:[{title:"String",value:"string"},{title:"Integer",value:"int"},{title:"Double",value:"double"},{title:"Boolean",value:"boolean"}],defaultValue:["int","boolean"],placeholder:"这里可以多选",validateRules:[{required:!0,message:"请选择${title}"}]},{title:"字段长度",key:"dbLength",width:"100px",type:o["a"].inputNumber,defaultValue:32,placeholder:"${title}",validateRules:[{required:!0,message:"请输入${title}"}]},{title:"日期",key:"datetime",width:"320px",type:o["a"].datetime,defaultValue:"2019-4-30 14:52:22",placeholder:"请选择${title}",validateRules:[{required:!0,message:"请选择${title}"}]},{title:"可以为空",key:"isNull",width:"100px",type:o["a"].checkbox,customValue:["Y","N"],defaultChecked:!1},{title:"操作",key:"action",width:"100px",type:o["a"].slot,slotName:"action",defaultValue:"删除"}],dataSource:[],selectedRowIds:[]}},mounted:function(){this.randomData(23,!1)},methods:{handleTableCheck:function(){var e=this;this.$refs.editableTable.getValues((function(t){0===t?e.$message.success("验证通过"):e.$message.error("验证未通过")}))},handleTableGet:function(){this.$refs.editableTable.getValues((function(e,t){}),!1),this.$message.info("获取值成功，请看控制台输出")},handleTableSet:function(){this.randomData(1e3,!0)},handleSelectRowChange:function(e){this.selectedRowIds=e},randomData:function(e){var t=this,a=arguments.length>1&&void 0!==arguments[1]&&arguments[1];a&&(this.loading=!0);for(var n=function(){var e=parseInt(Object(u["g"])(1e3,9999999999999));return i()(new Date(e)).format("YYYY-MM-DD HH:mm:ss")},l=Date.now(),r=[],o=0;o<e;o++)r.push({id:Object(u["i"])(),dbFieldName:"name_".concat(o+1),multipleSelect:["string",["int","double","boolean"][Object(u["g"])(0,2)]],dbFieldType:["string","int","double","boolean"][Object(u["g"])(0,3)],dbLength:Object(u["g"])(0,233),datetime:n(),isNull:["Y","N"][Object(u["g"])(0,1)]});this.dataSource=r;var c=Date.now(),s=c-l;a&&s<e&&setTimeout((function(){t.loading=!1}),e-s)},handleDelete:function(e){var t=e.rowId,a=e.target;a.removeRows(t)}}},d=s,f=a("2877"),p=Object(f["a"])(d,n,l,!1,null,"adf2922e",null);t["default"]=p.exports}}]);