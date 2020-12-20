$(function() {
    var id=$.cookie("id");
    var nickname=$.cookie("name");
    $("#nickName").text(nickname);
    function findAll() {
        $.ajax({
            url: "../userFindAll",
            method: "post",
            dataType: "Json",
            data: {
                hostId: id
            },
            success: function (data) {
                if (data == null){
                    let dialog1 = "<li class='dialog'>\n" +
                        "\t<div class='dialog-avator'>\n" +
                        "\t</div>\n" +
                        "\t <a href='windows.html'><span class='dialog-name ellipsis'>您当前还没有好友</span></a>\n" +
                        "\t<a href='#' class='delete'><div class='label dialog-label purple'></div></a>\n" +
                        "</li>";
                    $(".dialog-list").append(dialog1);
                    return;
                }
                for (var i = 0; i < data.length; i++) {
                    let dialog1 = "<li class='dialog'>\n" +
                        "\t<div class='dialog-avator'>\n" +
                        "\t\t<div class='img-bg avatar' style='background-images: url(../images/gree.jpg);'></div>\n" +
                        "\t</div>\n" +
                        "\t <a href='windows.html'><span class='dialog-name ellipsis'>" + data[i].nickname + "</span></a>\n" +
                        "\t<a href='#' class='delete'><div class='label dialog-label purple'>删除</div></a>\n" +
                        "</li>";
                    $(".dialog-list").append(dialog1);
                }
            }
        });
    }
    findAll();
    $("body").on("click", ".delete", function() {
        var flag=confirm("你确定要删除此好友嘛");
        if (flag){
            var nickName=$(this).prev().text();
            $.ajax({
                url : "../deleteFriend",
                method : "post",
                dataType: "Json",
                data : {
                    hostId : 10001,
                    nickName : nickName
                },
                success : function (data){
                    if (data) {
                        $(".dialog-list").html(" ");
                        findAll();
                    }else {
                        alert("删除失败");
                    }
                }
            })
        }
    });
    $(".dialog").on("click", function(){
        $(".dialog").removeClass("active");
        $(this).addClass("active");
    })

    //修改发送的快捷键
    $(".input-field--choose-keys").on("click", function(){
        $(".hot-keys").fadeIn();
    })
    $(".hot-keys > li").mouseenter(function(){
        $(".hot-keys > li").removeClass("hot-keys_item--active");
        $(this).addClass("hot-keys_item--active");
    })
    $(".hot-keys > li").on("click", function(){
        $(".hot-keys").fadeOut();
        $(".send-textarea").focus();
        //修改对应的快捷键
        if($(".hot-keys > li").index(this) == 0){
            $(".send-textarea").unbind();
            $(".send-textarea").keydown(function(e) {
                if(e.ctrlKey && e.which == 13) {
                    return;
                }
                if(e.which == 13){
                    console.log("当前发送消息的快捷键：Enter");
                    console.log("提交对话内容")
                }
            });
        }else{
            $(".send-textarea").unbind();
            $(".send-textarea").keydown(function(e) {
                if(e.ctrlKey && e.which == 13) {
                    console.log("当前发送消息的快捷键：Ctrl + Enter");
                    console.log("提交对话内容")
                }
            });
        }
    })
    console.log("当前发送消息的快捷键：Enter");
    $(".send-textarea").keydown(function(e) {
        if(e.ctrlKey && e.which == 13) {
            return;
        }
        if(e.which == 13){
            console.log("当前发送消息的快捷键：Enter");
            console.log("提交对话内容")
        }
    });

    //创建表情面板并添加事件
    create_emoj_items()
    $(document).click(function () { //点击页面的任何地方，隐藏表情面板
        $(".input-field--emoji").offset({"top": -255, "left": 652});
    });
    $(".input-field--tool__emoji").on("click", function(e){
        $(".input-field--emoji").offset({"top": 495, "left": 652});
        //阻止冒泡事件，可以实现点击自己以外的地方就隐藏
        e.stopPropagation();
    })
    //鼠标经过或离开时，显示或隐藏表情动图
    $(".emoji-box--item").mouseenter(function(){
        $(this).children("div").css("display", "block");
    })
    $(".emoji-box--item").mouseleave(function(){
        $(this).children("div").css("display", "none");
    })
    //点击事件
    $(".emoji-box--item").click(function(e) {
        let imgName =  $(this).children("div").children("img").attr("name");
        console.log("当前图片名称：" + imgName);
        $(".send-textarea").append(imgName);
        //文本框最后一行获得焦点
        placeCaretAtEnd($(".send-textarea").get(0));
    });


    //显示图片选择框
    $(".input-field--tool__image").on("click", function(){
        //触发隐藏文件框的click事件
        $("#upload").trigger("click");
    })
    $("#upload").bind("input propertychange", function(){
        $(".send-textarea").append($("#upload").val())
        //文本框最后一行获得焦点
        placeCaretAtEnd($(".send-textarea").get(0));
    })

    //评价服务
    $(".input-field--tool__evaluate").on("click", function(){
        $(".mask").css("display", "block");
    })

    $(".rating-stars > div").on("click", function (e) {
        //设置所有的同胞元素
        $(this).siblings().removeClass("white-star");
        $(this).siblings().addClass("red-star");
        //设置所有的跟随同胞元素
        $(this).nextAll().removeClass("red-star");
        $(this).nextAll().addClass("white-star");
        $(this).addClass("red-star");
    })

    $(".close-icon").on("click", function () {
        $(".mask").css("display", "none");
    })
});

function placeCaretAtEnd(jsDom) {    //传入光标要去的jsDom节点
    jsDom.focus();
    if (typeof window.getSelection != "undefined" && typeof document.createRange != "undefined") {
        var range = document.createRange();
        range.selectNodeContents(jsDom);
        range.collapse(false);
        var sel = window.getSelection();
        sel.removeAllRanges();
        sel.addRange(range);
    } else if (typeof document.body.createTextRange != "undefined") {
        var textRange = document.body.createTextRange();
        textRange.moveToElementText(jsDom);
        textRange.collapse(false);
        textRange.select();
    }
}

/**
 * 创建表情面板的表情项
 * <div class='emoji-box--item' style='background-images: url(images/classic2.gif); background-position: 0px 0px;'>
 *     <div class='emoji-box--item_preview'>
 *         <img src='//static.360buyimg.com/im/w_web/img/classic/s01.gif' name='//static.360buyimg.com/im/w_web/img/classic/s01.gif'>
 *     </div>
 * </div>
 */
function create_emoj_items(){
    let element = "<div class='input-field--emoji'>\n" +
                  "  <div class='emoji-box'>\n" +
                  "    <div class='emoji-box--container emoji-box--container__classic'>\n" +
                  "      <div>\n";
    let count = 1;
    for(let i = 0; i < 12; i++){
        let x = 0 - 38 * i;
        for(let j = 0; j < 6; j++){
            let y = 0 - 38 * j;
            element += `        <div class='emoji-box--item' style='background: url(../images/classic2.gif) ${x}px ${y}px no-repeat;'>\n`;
            element += `           <div class='emoji-box--item_preview'>`;
            let img_no = count <= 9 ? "0" + count : count;
            element += `<img src='images/classic/s${img_no}.gif' name='images/classic/s${img_no}.gif'>`;
            element += "</div>\n";
            element += "        </div>\n"
            count++;
        }
    }
    element += "        </div>\n" +
        "      </div>\n" +
        "      <div class='emoji-box--tabs'>\n" +
        "          <div class='emoji-box--tab emoji-box--tab__active'>经典</div>\n" +
        "      </div>\n" +
        "   </div>\n" +
        "</div>";
    // console.log(element);
    $("body > div").append(element);
    // $(".input-field--emoji").offset({"top": 495, "left": 652});
}