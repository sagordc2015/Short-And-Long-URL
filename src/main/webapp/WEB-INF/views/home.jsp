<%--
  Created by IntelliJ IDEA.
  User: sagor
  Date: 8/19/2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous"></script>


</head>
<body>
<div class="container" style="margin-top: 15%">

    <div class="row align-items-center">
        <div class="col-3"></div>
        <div class="col-6">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#shortToLongUrl">
                Short To Long URL
            </button>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#longToShortUrl">
                Long To Short URL
            </button>
        </div>
        <div class="col-3"></div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="shortToLongUrl" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel1" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel1">Short To Long URL</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="short-long">@</span>
                        <input type="text" class="form-control" placeholder="URL" aria-label="Username" aria-describedby="short-long" id="shortUrlId">
                        <button class="btn btn-outline-secondary btn-primary" type="button" onclick="shortToLongUrl()">Button</button>
                    </div>
                    <div class="input-group flex-nowrap">
                        <input type="text" class="form-control" placeholder="Long URL" aria-label="LongUrl" readonly id="showLongUrl">
                    </div>
                </div>
                <div class="modal-footer">
                    <%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
                    <%--                    <button type="button" class="btn btn-primary">Understood</button>--%>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="longToShortUrl" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Long To Short URL</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="long-short">@</span>
                        <input type="text" class="form-control" placeholder="URL" aria-label="Username" aria-describedby="long-short" id="longUrlId">
                        <button class="btn btn-outline-secondary btn-primary" type="button" onclick="longToShortUrl()">Button</button>
                    </div>
                    <div class="input-group flex-nowrap">
                        <input type="text" class="form-control" placeholder="Short URL" aria-label="ShortUrl" readonly="true" id="showShortUrl">
                    </div>
                </div>
                <div class="modal-footer">
                    <%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
                    <%--                    <button type="button" class="btn btn-primary">Understood</button>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function longToShortUrl() {
        var longValue = document.getElementById('longUrlId').value;
        console.log(longValue);
        $.ajax({
            type: 'post',
            url: '/longToShortUrl?longUrl='+encodeURIComponent(longValue),
            dataType: 'json',
            success: function(data) {
                console.log(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
    }
    function shortToLongUrl() {
        var shortValue = document.getElementById('shortUrlId').value;
        console.log(shortValue);
        $.ajax({
            type: 'post',
            url: '/shortToLongUrl/'+shortValue,
            dataType: 'json',
            success: function(data) {
                console.log(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
    }
</script>
</body>
</html>
