(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-46afe308","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6","chunk-2d20fed6","chunk-46afe308"],{b65a:function(e,t,a){"use strict";a.d(t,"a",(function(){return d}));a("8e6e"),a("7f7f");var n=a("ade3"),i=(a("456d"),a("ac6a"),a("ca00")),r=a("0fea"),s=a("2b0e"),o=a("9fb0");function c(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function l(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?c(Object(a),!0).forEach((function(t){Object(n["a"])(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):c(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}var d={data:function(){return{tokenHeader:{"X-Access-Token":s["default"].ls.get(o["a"])},queryParam:{},dataSource:[],ipagination:{current:1,pageSize:10,pageSizeOptions:["10","20","30"],showTotal:function(e,t){return t[0]+"-"+t[1]+" 共"+e+"条"},showQuickJumper:!0,showSizeChanger:!0,total:0},isorter:{column:"createTime",order:"desc"},filters:{},loading:!1,selectedRowKeys:[],selectionRows:[],toggleSearchStatus:!1,superQueryFlag:!1,superQueryParams:""}},created:function(){this.disableMixinCreated||(this.loadData(),this.initDictConfig())},methods:{loadData:function(e){var t=this;if(this.url.list){1===e&&(this.ipagination.current=1);var a=this.getQueryParams();this.loading=!0,Object(r["c"])(this.url.list,a).then((function(e){e.success&&(t.dataSource=e.result.records,t.ipagination.total=e.result.total),510===e.code&&t.$message.warning(e.message),t.loading=!1}))}else this.$message.error("请设置url.list属性!")},initDictConfig:function(){},handleSuperQuery:function(e){e?(this.superQueryFlag=!0,this.superQueryParams=JSON.stringify(e)):(this.superQueryParams="",this.superQueryFlag=!1),this.loadData()},getQueryParams:function(){var e={};this.superQueryParams&&(e["superQueryParams"]=encodeURI(this.superQueryParams));var t=Object.assign(e,this.queryParam,this.isorter,this.filters);return t.field=this.getQueryField(),t.pageNo=this.ipagination.current,t.pageSize=this.ipagination.pageSize,Object(i["d"])(t)},getQueryField:function(){var e="id,";return this.columns.forEach((function(t){e+=","+t.dataIndex})),e},onSelectChange:function(e,t){this.selectedRowKeys=e,this.selectionRows=t},onClearSelected:function(){this.selectedRowKeys=[],this.selectionRows=[]},searchQuery:function(){this.loadData(1)},superQuery:function(){this.$refs.superQueryModal.show()},searchReset:function(){this.queryParam={},this.loadData(1)},batchDel:function(){if(this.url.deleteBatch)if(this.selectedRowKeys.length<=0)this.$message.warning("请选择一条记录！");else{for(var e="",t=0;t<this.selectedRowKeys.length;t++)e+=this.selectedRowKeys[t]+",";var a=this;this.$confirm({title:"确认删除",content:"是否删除选中数据?",onOk:function(){a.loading=!0,Object(r["a"])(a.url.deleteBatch,{ids:e}).then((function(e){e.success?(a.$message.success(e.message),a.loadData(),a.onClearSelected()):a.$message.warning(e.message)})).finally((function(){a.loading=!1}))}})}else this.$message.error("请设置url.deleteBatch属性!")},handleDelete:function(e){if(this.url.delete){var t=this;Object(r["a"])(t.url.delete,{id:e}).then((function(e){e.success?(t.$message.success(e.message),t.loadData()):t.$message.warning(e.message)}))}else this.$message.error("请设置url.delete属性!")},handleEdit:function(e){this.$refs.modalForm.edit(e),this.$refs.modalForm.title="编辑",this.$refs.modalForm.disableSubmit=!1},handleAdd:function(){this.$refs.modalForm.add(),this.$refs.modalForm.title="新增",this.$refs.modalForm.disableSubmit=!1},handleTableChange:function(e,t,a){Object.keys(a).length>0&&(this.isorter.column=a.field,this.isorter.order="ascend"==a.order?"asc":"desc"),this.ipagination=e,this.loadData()},handleToggleSearch:function(){this.toggleSearchStatus=!this.toggleSearchStatus},modalFormOk:function(){this.loadData()},handleDetail:function(e){this.$refs.modalForm.edit(e),this.$refs.modalForm.title="详情",this.$refs.modalForm.disableSubmit=!0},handleExportXls2:function(){var e=encodeURI(JSON.stringify(this.getQueryParams())),t="".concat(window._CONFIG["domianURL"],"/").concat(this.url.exportXlsUrl,"?paramsStr=").concat(e);window.location.href=t},handleExportXls:function(e){var t=this;e&&"string"==typeof e||(e="导出文件");var a=l({},this.queryParam);this.selectedRowKeys&&this.selectedRowKeys.length>0&&(a["selections"]=this.selectedRowKeys.join(",")),Object(r["b"])(this.url.exportXlsUrl,a).then((function(a){if(a)if("undefined"!==typeof window.navigator.msSaveBlob)window.navigator.msSaveBlob(new Blob([a],{type:"application/vnd.ms-excel"}),e+".xls");else{var n=window.URL.createObjectURL(new Blob([a],{type:"application/vnd.ms-excel"})),i=document.createElement("a");i.style.display="none",i.href=n,i.setAttribute("download",e+".xls"),document.body.appendChild(i),i.click(),document.body.removeChild(i),window.URL.revokeObjectURL(n)}else t.$message.warning("文件下载失败")}))},handleImportExcel:function(e){var t=this.$createElement;if(e.file.status,"done"===e.file.status)if(e.file.response.success){if(201===e.file.response.code){var a=e.file.response,n=a.message,i=a.result,r=i.msg,s=i.fileUrl,o=i.fileName,c=window._CONFIG["domianURL"]+s;this.$warning({title:n,content:t("div",[t("span",[r]),t("br"),t("span",["具体详情请 ",t("a",{attrs:{href:c,target:"_blank",download:o}},["点击下载"])," "])])})}else this.$message.success(e.file.response.message||"".concat(e.file.name," 文件上传成功"));this.loadData()}else this.$message.error("".concat(e.file.name," ").concat(e.file.response.message,"."));else"error"===e.file.status&&this.$message.error("文件上传失败: ".concat(e.file.msg," "))},getImgView:function(e){return e&&e.indexOf(",")>0&&(e=e.substring(0,e.indexOf(","))),window._CONFIG["staticDomainURL"]+"/"+e},uploadFile:function(e){e?(e.indexOf(",")>0&&(e=e.substring(0,e.indexOf(","))),window.open(window._CONFIG["staticDomainURL"]+"/"+e)):this.$message.warning("未知的文件")}}}},c34c:function(e,t,a){"use strict";a("c66c")},c66c:function(e,t,a){},ddf2:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-card",{attrs:{bordered:!1}},[a("div",{staticClass:"table-operator"},[a("a-button",{attrs:{type:"primary",icon:"plus"},on:{click:e.handleAdd}},[e._v("新增")]),e.selectedRowKeys.length>0?a("a-dropdown",[a("a-menu",{attrs:{slot:"overlay"},slot:"overlay"},[a("a-menu-item",{key:"1",on:{click:e.batchDel}},[a("a-icon",{attrs:{type:"delete"}}),e._v("删除")],1)],1),a("a-button",{staticStyle:{"margin-left":"8px"}},[e._v(" 批量操作 "),a("a-icon",{attrs:{type:"down"}})],1)],1):e._e()],1),a("div",[a("div",{staticClass:"ant-alert ant-alert-info",staticStyle:{"margin-bottom":"16px"}},[a("i",{staticClass:"anticon anticon-info-circle ant-alert-icon"}),e._v(" 已选择 "),a("a",{staticStyle:{"font-weight":"600"}},[e._v(e._s(e.selectedRowKeys.length))]),e._v("项\n      "),a("a",{staticStyle:{"margin-left":"24px"},on:{click:e.onClearSelected}},[e._v("清空")])]),a("a-table",e._b({ref:"table",attrs:{size:"middle",rowKey:"id",columns:e.columns,dataSource:e.dataSource,pagination:e.ipagination,loading:e.loading,expandedRowKeys:e.expandedRowKeys},on:{change:e.handleTableChange,expand:e.handleExpand},scopedSlots:e._u([{key:"action",fn:function(t,n){return a("span",{},[a("a",{on:{click:function(t){return e.handleEdit(n)}}},[e._v("编辑")]),a("a-divider",{attrs:{type:"vertical"}}),a("a-popconfirm",{attrs:{title:"确定删除吗?"},on:{confirm:function(){return e.handleDelete(n.id)}}},[a("a",[e._v("删除")])])],1)}}])},"a-table",e.tableProps,!1))],1),a("sysCategory-modal",{ref:"modalForm",on:{ok:e.modalFormOk}})],1)},i=[],r=(a("ac6a"),a("ac4d"),a("8a81"),a("5df3"),a("1c4c"),a("7f7f"),a("6b54"),a("96cf"),a("1da1")),s=a("2909"),o=(a("c5f6"),a("0fea")),c=a("b65a"),l=a("f1cf");function d(e,t){var a;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(a=u(e))||t&&e&&"number"===typeof e.length){a&&(e=a);var n=0,i=function(){};return{s:i,n:function(){return n>=e.length?{done:!0}:{done:!1,value:e[n++]}},e:function(e){throw e},f:i}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var r,s=!0,o=!1;return{s:function(){a=e[Symbol.iterator]()},n:function(){var e=a.next();return s=e.done,e},e:function(e){o=!0,r=e},f:function(){try{s||null==a.return||a.return()}finally{if(o)throw r}}}}function u(e,t){if(e){if("string"===typeof e)return h(e,t);var a=Object.prototype.toString.call(e).slice(8,-1);return"Object"===a&&e.constructor&&(a=e.constructor.name),"Map"===a||"Set"===a?Array.from(e):"Arguments"===a||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(a)?h(e,t):void 0}}function h(e,t){(null==t||t>e.length)&&(t=e.length);for(var a=0,n=new Array(t);a<t;a++)n[a]=e[a];return n}var f={name:"SysCategoryList",mixins:[c["a"]],components:{SysCategoryModal:l["default"]},data:function(){return{description:"分类字典管理页面",columns:[{title:"类型名称",align:"left",dataIndex:"name"},{title:"类型编码",align:"left",dataIndex:"code"},{title:"操作",dataIndex:"action",align:"center",scopedSlots:{customRender:"action"}}],url:{list:"/sys/category/rootList",childList:"/sys/category/childList",delete:"/sys/category/delete",deleteBatch:"/sys/category/deleteBatch",exportXlsUrl:"/sys/category/exportXls",importExcelUrl:"sys/category/importExcel"},expandedRowKeys:[],hasChildrenField:"hasChild",pidField:"pid",dictOptions:{}}},computed:{importExcelUrl:function(){return"".concat(window._CONFIG["domianURL"],"/").concat(this.url.importExcelUrl)},tableProps:function(){var e=this;return{rowSelection:{selectedRowKeys:e.selectedRowKeys,onChange:function(t){return e.selectedRowKeys=t}}}}},methods:{loadData:function(e){var t=this;1==e&&(this.ipagination.current=1),this.loading=!0,this.expandedRowKeys=[];var a=this.getQueryParams();return new Promise((function(e){Object(o["c"])(t.url.list,a).then((function(a){if(a.success){var n=a.result;Number(n.total)>0?(t.ipagination.total=Number(n.total),t.dataSource=t.getDataByResult(a.result.records),e()):(t.ipagination.total=0,t.dataSource=[])}else t.$message.warning(a.message);t.loading=!1}))}))},getDataByResult:function(e){var t=this;return e.map((function(e){if("1"==e[t.hasChildrenField]){var a={id:e.id+"_loadChild",name:"loading...",isLoading:!0};e.children=[a]}return e}))},handleExpand:function(e,t){var a=this;if(e){if(this.expandedRowKeys.push(t.id),t.children.length>0&&!0===t.children[0].isLoading){var n=this.getQueryParams();n[this.pidField]=t.id,Object(o["c"])(this.url.childList,n).then((function(e){e.success?e.result&&e.result.length>0?(t.children=a.getDataByResult(e.result),a.dataSource=Object(s["a"])(a.dataSource)):(t.children="",t.hasChildrenField="0"):a.$message.warning(e.message)}))}}else{var i=this.expandedRowKeys.indexOf(t.id);i>=0&&this.expandedRowKeys.splice(i,1)}},initDictConfig:function(){},modalFormOk:function(e,t){e.id?(this.editOk(e,this.dataSource),this.dataSource=Object(s["a"])(this.dataSource)):this.addOk(e,t)},editOk:function(e,t){if(t&&t.length>0)for(var a=0;a<t.length;a++){if(t[a].id==e.id){t[a]=e;break}this.editOk(e,t[a].children)}},addOk:function(){var e=Object(r["a"])(regeneratorRuntime.mark((function e(t,a){var n,i,r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t[this.pidField]){e.next=4;break}this.loadData(),e.next=23;break;case 4:this.expandedRowKeys=[],n=d(a),e.prev=7,n.s();case 9:if((i=n.n()).done){e.next=15;break}return r=i.value,e.next=13,this.expandTreeNode(r);case 13:e.next=9;break;case 15:e.next=20;break;case 17:e.prev=17,e.t0=e["catch"](7),n.e(e.t0);case 20:return e.prev=20,n.f(),e.finish(20);case 23:case"end":return e.stop()}}),e,this,[[7,17,20,23]])})));function t(t,a){return e.apply(this,arguments)}return t}(),expandTreeNode:function(e){var t=this;return new Promise((function(a,n){t.getFormDataById(e,t.dataSource);var i=t.parentFormData;t.expandedRowKeys.push(e);var r=t.getQueryParams();r[t.pidField]=e,Object(o["c"])(t.url.childList,r).then((function(e){e.success&&e.result&&e.result.length>0?(i.children=t.getDataByResult(e.result),t.dataSource=Object(s["a"])(t.dataSource),a()):n()}))}))},getFormDataById:function(e,t){if(t&&t.length>0)for(var a=0;a<t.length;a++)t[a].id==e?this.parentFormData=t[a]:this.getFormDataById(e,t[a].children)}}},g=f,m=(a("c34c"),a("2877")),p=Object(m["a"])(g,n,i,!1,null,"03adeaca",null);t["default"]=p.exports}}]);