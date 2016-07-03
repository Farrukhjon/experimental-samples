/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

$(document).ready(function () {
    var baseURL = "/posts/";
    $("#btn").click(function () {
        var postId = $("#post_id_in").val();
        var resourceUrl = baseURL + postId;
        if (postId) {
            $.getJSON(resourceUrl, function (response) {
                var post = response.body;
                $("#post_rows")
                    .append('<tr>')
                        .append('<td>' + post.id + '</td>td>')
                        .append('<td>' + post.userId + '</td>td>')
                        .append('<td>' + post.title + '</td>td>')
                        .append('<td>' + post.body + '</td>td>')
                    .append('<tr>');

            }).fail(function (errorResponse) {
                alert(errorResponse.responseText)
            });
        }
    });
});


