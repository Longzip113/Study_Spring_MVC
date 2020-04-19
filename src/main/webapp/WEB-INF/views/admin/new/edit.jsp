<%@ page contentType="text/html;charset=UTF-8" language="java"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/api/new" />
        <c:url var="NewURL" value="/quan-tri/bai-viet/danh-sach" />
        <c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua" />
        <html>

        <head>
            <title>Chỉnh sửa bài viết</title>
        </head>

        <body>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs" id="breadcrumbs">
                        <script type="text/javascript">
                            try {
                                ace.settings.check('breadcrumbs', 'fixed')
                            } catch (e) {}
                        </script>
                        <ul class="breadcrumb">
                            <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
                            <li class="active">Chỉnh sửa bài viết</li>
                        </ul>
                        <!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">

                                <c:if test="${not empty message}">
                                    <div class="alert alert-${alert}">${message}</div>
                                </c:if>

                                <form:form id="formSubmit" modelAttribute="model">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Thể
									loại </label>
                                        <div class="col-sm-9">
	                                        <form:select path="categoryCode" id="categoryCode">
	                                        	<form:option value="" label="Chọn loại bài viết" />
	                                        	<form:options items="${categoryModel}"/>
	                                         </form:select>s
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tiêu
									đề </label>
                                        <div class="col-sm-9">
                                            <%-- <input type="text" class="form-control" value="${model.title}" name="title" id="title" /> --%>
                                            <form:input path="title" cssClass="form-control" id="title"/>
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Hình
									đại diện </label>
                                        <div class="col-sm-9">
                                            <input type="file" class="form-control" value="${model.thumbnail}" name="thumbnail" id="thumbnail" />
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Mô
									tả ngán </label>
                                        <div class="col-sm-9">
                                            <%-- <input type="text" class="form-control" value="${model.shortDescripTion}" name="shortDescripTion" id="shortDescripTion" /> --%>
                                        	<form:input path="shortDescripTion" cssClass="form-control" id="shortDescripTion"/>
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Nội
									dung </label>
                                        <div class="col-sm-9">
                                            <!-- <input type="text" class="form-control" value="${model.content}" name="content" id="content" /> -->
                                            <%-- <textarea name="content" id="content" cols="123" rows="20">${model.content}</textarea> --%>
                                            <form:textarea path="content" cols="123" rows="20" cssClass="form-control" id="content"/>
                                        </div>
                                    </div>
									<form:hidden path="id" id="newId"/>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <c:if test="${not empty model.categoryCode}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>
                                            <c:if test="${empty model.categoryCode}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>

                                        </div>
                                    </div>
                                    <input type="hidden" value="${model.id}" id="id" name="id">
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>/* 
                var editor = '';
                $(document).ready(function() { // những thú trong đây sẽ chạy đầu tiên khi chạy sever giông hàm main() bên lap trinh console
                    editor = CKEDITOR.replace('content');
                }); */
                $('#btnAddOrUpdateNew').click(function(e) {
                    e.preventDefault(); //Tránh submit nhầm url 
                    // var title = $('#title').val();
                    // var categoryCode = $('#categoryCode').val();
                    // var thumbnail = $('#thumbnail').val();
                    // var shortDescripTion = $('#shortDescripTion').val();
                    // var content = $('#content').val();
                    var data = {};
                    var formData = $('#formSubmit').serializeArray(); // lay gia tri cua các thẻ index là name && value tạo thành mảng
                    $.each(formData, function(i, v) {
                        data["" + v.name + ""] = v.value; // lập để lấy dữ liệu name value vào data
                    });
                    //data["content"] = editor.getData(); // dùng để get data từ textaria CKEDITOR
                    var id = $('#newId').val();
                    if (id == "") {
                        addNew(data);
                    } else {
                        upDataNew(data);
                    }
                });

                function addNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            window.location.href = "${editNewURL}?id=" + result.id +"&message=insert_success";
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?page=1&limit=2&message=error_system" ;
                        },
                    });
                }

                function upDataNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            window.location.href = "${editNewURL}?id=" + result.id +"&message=updata_success";
                        },
                        error: function(error) {
                            window.location.href = "${editNewURL}?id=" + result.id +"&message=error_system";
                        },
                    });
                }
            </script>
        </body>

        </html>