(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-250105d0","chunk-14a31191","chunk-2f6039ec","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6"],{"1d8c":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-card",{attrs:{bordered:!1}},[a("div",{staticClass:"table-page-search-wrapper"},[a("a-form",{attrs:{layout:"inline"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchQuery(t)}}},[a("a-row",{attrs:{gutter:24}},[a("a-col",{attrs:{md:6,sm:8}},[a("a-form-item",{attrs:{label:"职务编码"}},[a("a-input",{attrs:{placeholder:"请输入职务编码"},model:{value:e.queryParam.code,callback:function(t){e.$set(e.queryParam,"code",t)},expression:"queryParam.code"}})],1)],1),a("a-col",{attrs:{md:6,sm:8}},[a("a-form-item",{attrs:{label:"职务名称"}},[a("a-input",{attrs:{placeholder:"请输入职务名称"},model:{value:e.queryParam.name,callback:function(t){e.$set(e.queryParam,"name",t)},expression:"queryParam.name"}})],1)],1),e.toggleSearchStatus?[a("a-col",{attrs:{md:6,sm:8}},[a("a-form-item",{attrs:{label:"职级"}},[a("j-dict-select-tag",{attrs:{placeholder:"请选择职级",dictCode:"position_rank"},model:{value:e.queryParam.postRank,callback:function(t){e.$set(e.queryParam,"postRank",t)},expression:"queryParam.postRank"}})],1)],1)]:e._e(),a("a-col",{attrs:{md:6,sm:8}},[a("span",{staticClass:"table-page-search-submitButtons",staticStyle:{float:"left",overflow:"hidden"}},[a("a-button",{attrs:{type:"primary",icon:"search"},on:{click:e.searchQuery}},[e._v("查询")]),a("a-button",{staticStyle:{"margin-left":"8px"},attrs:{type:"primary",icon:"reload"},on:{click:e.searchReset}},[e._v("重置")]),a("a",{staticStyle:{"margin-left":"8px"},on:{click:e.handleToggleSearch}},[e._v("\n              "+e._s(e.toggleSearchStatus?"收起":"展开")+"\n              "),a("a-icon",{attrs:{type:e.toggleSearchStatus?"up":"down"}})],1)],1)])],2)],1)],1),a("div",{staticClass:"table-operator"},[a("a-button",{attrs:{type:"primary",icon:"plus"},on:{click:e.handleAdd}},[e._v("新增")]),a("a-button",{attrs:{type:"primary",icon:"download"},on:{click:function(t){return e.handleExportXls("职务表")}}},[e._v("导出")]),a("a-upload",{attrs:{name:"file",showUploadList:!1,multiple:!1,headers:e.tokenHeader,action:e.importExcelUrl},on:{change:e.handleImportExcel}},[a("a-button",{attrs:{type:"primary",icon:"import"}},[e._v("导入")])],1),e.selectedRowKeys.length>0?a("a-dropdown",[a("a-menu",{attrs:{slot:"overlay"},slot:"overlay"},[a("a-menu-item",{key:"1",on:{click:e.batchDel}},[a("a-icon",{attrs:{type:"delete"}}),e._v("\n          删除\n        ")],1)],1),a("a-button",{staticStyle:{"margin-left":"8px"}},[e._v(" 批量操作\n        "),a("a-icon",{attrs:{type:"down"}})],1)],1):e._e()],1),a("div",[a("div",{staticClass:"ant-alert ant-alert-info",staticStyle:{"margin-bottom":"16px"}},[a("i",{staticClass:"anticon anticon-info-circle ant-alert-icon"}),e._v(" 已选择 "),a("a",{staticStyle:{"font-weight":"600"}},[e._v(e._s(e.selectedRowKeys.length))]),e._v("项\n      "),a("a",{staticStyle:{"margin-left":"24px"},on:{click:e.onClearSelected}},[e._v("清空")])]),a("a-table",{ref:"table",attrs:{size:"middle",bordered:"",rowKey:"id",columns:e.columns,dataSource:e.dataSource,pagination:e.ipagination,loading:e.loading,rowSelection:{selectedRowKeys:e.selectedRowKeys,onChange:e.onSelectChange}},on:{change:e.handleTableChange},scopedSlots:e._u([{key:"action",fn:function(t,n){return a("span",{},[a("a",{on:{click:function(t){return e.handleEdit(n)}}},[e._v("编辑")]),a("a-divider",{attrs:{type:"vertical"}}),a("a-dropdown",[a("a",{staticClass:"ant-dropdown-link"},[e._v("更多 "),a("a-icon",{attrs:{type:"down"}})],1),a("a-menu",{attrs:{slot:"overlay"},slot:"overlay"},[a("a-menu-item",[a("a-popconfirm",{attrs:{title:"确定删除吗?"},on:{confirm:function(){return e.handleDelete(n.id)}}},[a("a",[e._v("删除")])])],1)],1)],1)],1)}}])})],1),a("sysPosition-modal",{ref:"modalForm",on:{ok:e.modalFormOk}})],1)},r=[],i=a("8e7c"),s=a("b65a"),o=a("7b16"),l={name:"SysPositionList",mixins:[s["a"]],components:{SysPositionModal:i["default"],JDictSelectTag:o["default"]},data:function(){return{description:"职务表管理页面",columns:[{title:"#",dataIndex:"",key:"rowIndex",width:60,align:"center",customRender:function(e,t,a){return parseInt(a)+1}},{title:"职务编码",align:"center",dataIndex:"code"},{title:"职务名称",align:"center",dataIndex:"name"},{title:"职级",align:"center",dataIndex:"postRank_dictText"},{title:"操作",dataIndex:"action",align:"center",scopedSlots:{customRender:"action"}}],url:{list:"/sys/position/list",delete:"/sys/position/delete",deleteBatch:"/sys/position/deleteBatch",exportXlsUrl:"/sys/position/exportXls",importExcelUrl:"/sys/position/importExcel"}}},computed:{importExcelUrl:function(){return"".concat(window._CONFIG["domianURL"],"/").concat(this.url.importExcelUrl)}}},c=l,d=(a("6fe2"),a("2877")),u=Object(d["a"])(c,n,r,!1,null,"21287297",null);t["default"]=u.exports},"3b94":function(e,t,a){},"6fe2":function(e,t,a){"use strict";a("3b94")},"88bc":function(e,t,a){(function(t){var a=1/0,n=9007199254740991,r="[object Arguments]",i="[object Function]",s="[object GeneratorFunction]",o="[object Symbol]",l="object"==typeof t&&t&&t.Object===Object&&t,c="object"==typeof self&&self&&self.Object===Object&&self,d=l||c||Function("return this")();function u(e,t,a){switch(a.length){case 0:return e.call(t);case 1:return e.call(t,a[0]);case 2:return e.call(t,a[0],a[1]);case 3:return e.call(t,a[0],a[1],a[2])}return e.apply(t,a)}function m(e,t){var a=-1,n=e?e.length:0,r=Array(n);while(++a<n)r[a]=t(e[a],a,e);return r}function f(e,t){var a=-1,n=t.length,r=e.length;while(++a<n)e[r+a]=t[a];return e}var h=Object.prototype,p=h.hasOwnProperty,g=h.toString,y=d.Symbol,b=h.propertyIsEnumerable,v=y?y.isConcatSpreadable:void 0,w=Math.max;function k(e,t,a,n,r){var i=-1,s=e.length;a||(a=R),r||(r=[]);while(++i<s){var o=e[i];t>0&&a(o)?t>1?k(o,t-1,a,n,r):f(r,o):n||(r[r.length]=o)}return r}function O(e,t){return e=Object(e),S(e,t,(function(t,a){return a in e}))}function S(e,t,a){var n=-1,r=t.length,i={};while(++n<r){var s=t[n],o=e[s];a(o,s)&&(i[s]=o)}return i}function x(e,t){return t=w(void 0===t?e.length-1:t,0),function(){var a=arguments,n=-1,r=w(a.length-t,0),i=Array(r);while(++n<r)i[n]=a[t+n];n=-1;var s=Array(t+1);while(++n<t)s[n]=a[n];return s[t]=i,u(e,this,s)}}function R(e){return $(e)||j(e)||!!(v&&e&&e[v])}function C(e){if("string"==typeof e||I(e))return e;var t=e+"";return"0"==t&&1/e==-a?"-0":t}function j(e){return _(e)&&p.call(e,"callee")&&(!b.call(e,"callee")||g.call(e)==r)}var $=Array.isArray;function P(e){return null!=e&&D(e.length)&&!F(e)}function _(e){return Q(e)&&P(e)}function F(e){var t=E(e)?g.call(e):"";return t==i||t==s}function D(e){return"number"==typeof e&&e>-1&&e%1==0&&e<=n}function E(e){var t=typeof e;return!!e&&("object"==t||"function"==t)}function Q(e){return!!e&&"object"==typeof e}function I(e){return"symbol"==typeof e||Q(e)&&g.call(e)==o}var U=x((function(e,t){return null==e?{}:O(e,m(k(t,1),C))}));e.exports=U}).call(this,a("c8ba"))},"8e7c":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{title:e.title,width:800,visible:e.visible,maskClosable:!1,confirmLoading:e.confirmLoading,cancelText:"关闭"},on:{ok:e.handleOk,cancel:e.handleCancel}},[a("a-spin",{attrs:{spinning:e.confirmLoading}},[a("a-form",{attrs:{form:e.form}},[a("a-form-item",{attrs:{labelCol:e.labelCol,wrapperCol:e.wrapperCol,label:"职务编码"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["code",e.validatorRules.code],expression:"['code', validatorRules.code]"}],attrs:{placeholder:"请输入职务编码"}})],1),a("a-form-item",{attrs:{labelCol:e.labelCol,wrapperCol:e.wrapperCol,label:"职务名称"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["name",e.validatorRules.name],expression:"['name', validatorRules.name]"}],attrs:{placeholder:"请输入职务名称"}})],1),a("a-form-item",{attrs:{labelCol:e.labelCol,wrapperCol:e.wrapperCol,label:"职级"}},[a("j-dict-select-tag",{directives:[{name:"decorator",rawName:"v-decorator",value:["postRank",e.validatorRules.postRank],expression:"['postRank', validatorRules.postRank]"}],attrs:{placeholder:"请选择职级",triggerChange:!0,dictCode:"position_rank"}})],1)],1)],1)],1)},r=[],i=a("88bc"),s=a.n(i),o=a("0fea"),l=a("4ec3"),c=a("7b16"),d=null,u={name:"SysPositionModal",components:{JDictSelectTag:c["default"]},data:function(){var e=this;return{title:"操作",visible:!1,model:{},labelCol:{xs:{span:24},sm:{span:5}},wrapperCol:{xs:{span:24},sm:{span:16}},confirmLoading:!1,form:this.$form.createForm(this),validatorRules:{code:{rules:[{required:!0,message:"请输入职务编码"},{validator:function(t,a,n){d&&clearTimeout(d),d=setTimeout((function(){Object(l["m"])({tableName:"sys_position",fieldName:"code",fieldVal:a,dataId:e.model.id}).then((function(e){e.success?n():n(e.message)})).catch(console.error)}),300)}}]},name:{rules:[{required:!0,message:"请输入职务名称"}]},postRank:{rules:[{required:!0,message:"请选择职级"}]}},url:{add:"/sys/position/add",edit:"/sys/position/edit"}}},created:function(){},methods:{add:function(){this.edit({})},edit:function(e){var t=this;this.form.resetFields(),this.model=Object.assign({},e),this.visible=!0,this.$nextTick((function(){t.form.setFieldsValue(s()(t.model,"code","name","postRank"))}))},close:function(){this.$emit("close"),this.visible=!1},handleOk:function(){var e=this,t=this;this.form.validateFields((function(a,n){if(!a){t.confirmLoading=!0;var r="",i="";e.model.id?(r+=e.url.edit,i="put"):(r+=e.url.add,i="post");var s=Object.assign(e.model,n);Object(o["h"])(r,s,i).then((function(e){e.success?(t.$message.success(e.message),t.$emit("ok")):t.$message.warning(e.message)})).finally((function(){t.confirmLoading=!1,t.close()}))}}))},handleCancel:function(){this.close()}}},m=u,f=a("2877"),h=Object(f["a"])(m,n,r,!1,null,"3aaf2fb2",null);t["default"]=h.exports},b65a:function(e,t,a){"use strict";a.d(t,"a",(function(){return d}));a("8e6e"),a("7f7f");var n=a("ade3"),r=(a("456d"),a("ac6a"),a("ca00")),i=a("0fea"),s=a("2b0e"),o=a("9fb0");function l(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function c(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?l(Object(a),!0).forEach((function(t){Object(n["a"])(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):l(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}var d={data:function(){return{tokenHeader:{"X-Access-Token":s["default"].ls.get(o["a"])},queryParam:{},dataSource:[],ipagination:{current:1,pageSize:10,pageSizeOptions:["10","20","30"],showTotal:function(e,t){return t[0]+"-"+t[1]+" 共"+e+"条"},showQuickJumper:!0,showSizeChanger:!0,total:0},isorter:{column:"createTime",order:"desc"},filters:{},loading:!1,selectedRowKeys:[],selectionRows:[],toggleSearchStatus:!1,superQueryFlag:!1,superQueryParams:""}},created:function(){this.disableMixinCreated||(this.loadData(),this.initDictConfig())},methods:{loadData:function(e){var t=this;if(this.url.list){1===e&&(this.ipagination.current=1);var a=this.getQueryParams();this.loading=!0,Object(i["c"])(this.url.list,a).then((function(e){e.success&&(t.dataSource=e.result.records,t.ipagination.total=e.result.total),510===e.code&&t.$message.warning(e.message),t.loading=!1}))}else this.$message.error("请设置url.list属性!")},initDictConfig:function(){},handleSuperQuery:function(e){e?(this.superQueryFlag=!0,this.superQueryParams=JSON.stringify(e)):(this.superQueryParams="",this.superQueryFlag=!1),this.loadData()},getQueryParams:function(){var e={};this.superQueryParams&&(e["superQueryParams"]=encodeURI(this.superQueryParams));var t=Object.assign(e,this.queryParam,this.isorter,this.filters);return t.field=this.getQueryField(),t.pageNo=this.ipagination.current,t.pageSize=this.ipagination.pageSize,Object(r["d"])(t)},getQueryField:function(){var e="id,";return this.columns.forEach((function(t){e+=","+t.dataIndex})),e},onSelectChange:function(e,t){this.selectedRowKeys=e,this.selectionRows=t},onClearSelected:function(){this.selectedRowKeys=[],this.selectionRows=[]},searchQuery:function(){this.loadData(1)},superQuery:function(){this.$refs.superQueryModal.show()},searchReset:function(){this.queryParam={},this.loadData(1)},batchDel:function(){if(this.url.deleteBatch)if(this.selectedRowKeys.length<=0)this.$message.warning("请选择一条记录！");else{for(var e="",t=0;t<this.selectedRowKeys.length;t++)e+=this.selectedRowKeys[t]+",";var a=this;this.$confirm({title:"确认删除",content:"是否删除选中数据?",onOk:function(){a.loading=!0,Object(i["a"])(a.url.deleteBatch,{ids:e}).then((function(e){e.success?(a.$message.success(e.message),a.loadData(),a.onClearSelected()):a.$message.warning(e.message)})).finally((function(){a.loading=!1}))}})}else this.$message.error("请设置url.deleteBatch属性!")},handleDelete:function(e){if(this.url.delete){var t=this;Object(i["a"])(t.url.delete,{id:e}).then((function(e){e.success?(t.$message.success(e.message),t.loadData()):t.$message.warning(e.message)}))}else this.$message.error("请设置url.delete属性!")},handleEdit:function(e){this.$refs.modalForm.edit(e),this.$refs.modalForm.title="编辑",this.$refs.modalForm.disableSubmit=!1},handleAdd:function(){this.$refs.modalForm.add(),this.$refs.modalForm.title="新增",this.$refs.modalForm.disableSubmit=!1},handleTableChange:function(e,t,a){Object.keys(a).length>0&&(this.isorter.column=a.field,this.isorter.order="ascend"==a.order?"asc":"desc"),this.ipagination=e,this.loadData()},handleToggleSearch:function(){this.toggleSearchStatus=!this.toggleSearchStatus},modalFormOk:function(){this.loadData()},handleDetail:function(e){this.$refs.modalForm.edit(e),this.$refs.modalForm.title="详情",this.$refs.modalForm.disableSubmit=!0},handleExportXls2:function(){var e=encodeURI(JSON.stringify(this.getQueryParams())),t="".concat(window._CONFIG["domianURL"],"/").concat(this.url.exportXlsUrl,"?paramsStr=").concat(e);window.location.href=t},handleExportXls:function(e){var t=this;e&&"string"==typeof e||(e="导出文件");var a=c({},this.queryParam);this.selectedRowKeys&&this.selectedRowKeys.length>0&&(a["selections"]=this.selectedRowKeys.join(",")),Object(i["b"])(this.url.exportXlsUrl,a).then((function(a){if(a)if("undefined"!==typeof window.navigator.msSaveBlob)window.navigator.msSaveBlob(new Blob([a],{type:"application/vnd.ms-excel"}),e+".xls");else{var n=window.URL.createObjectURL(new Blob([a],{type:"application/vnd.ms-excel"})),r=document.createElement("a");r.style.display="none",r.href=n,r.setAttribute("download",e+".xls"),document.body.appendChild(r),r.click(),document.body.removeChild(r),window.URL.revokeObjectURL(n)}else t.$message.warning("文件下载失败")}))},handleImportExcel:function(e){var t=this.$createElement;if(e.file.status,"done"===e.file.status)if(e.file.response.success){if(201===e.file.response.code){var a=e.file.response,n=a.message,r=a.result,i=r.msg,s=r.fileUrl,o=r.fileName,l=window._CONFIG["domianURL"]+s;this.$warning({title:n,content:t("div",[t("span",[i]),t("br"),t("span",["具体详情请 ",t("a",{attrs:{href:l,target:"_blank",download:o}},["点击下载"])," "])])})}else this.$message.success(e.file.response.message||"".concat(e.file.name," 文件上传成功"));this.loadData()}else this.$message.error("".concat(e.file.name," ").concat(e.file.response.message,"."));else"error"===e.file.status&&this.$message.error("文件上传失败: ".concat(e.file.msg," "))},getImgView:function(e){return e&&e.indexOf(",")>0&&(e=e.substring(0,e.indexOf(","))),window._CONFIG["staticDomainURL"]+"/"+e},uploadFile:function(e){e?(e.indexOf(",")>0&&(e=e.substring(0,e.indexOf(","))),window.open(window._CONFIG["staticDomainURL"]+"/"+e)):this.$message.warning("未知的文件")}}}}}]);