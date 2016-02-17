<script type="text/javascript" src="resources/js/jqmodal/jqModal.min.js"></script>
<script type="text/javascript">
  function alertInfo(content){
    $('.m-alertinfo').show();
    $('.alertcontent').text(content);
    setTimeout("hideAlert()", 3000);
  }

  function hideAlert(){
    $('.m-alertinfo').hide();
  }
</script>

<div class="m-alertinfo">
  <label class="alertcontent"></label><img src="resources/img/front/cancel.jpg" onclick="hideAlert()">
</div>

