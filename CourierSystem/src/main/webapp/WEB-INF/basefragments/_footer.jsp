<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<footer
	style="bottom: 0; left: 0; position: relative; font-size : small; width: 100%;"
	class="page-footer font-small blue bg-nav"  >

	<div class="footer-copyright text-center py-3">
		<span id="myid" class="text-white"> </span> <a href="#" class="text-white">
		Firma de curierat rapid</a>
	</div>
</footer>
<script>
  var myid = document.getElementById("myid");
  var a = new Date().getFullYear();
  myid.innerHTML = a;
 </script>
