
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
		<script type="text/javascript" src="ressources/js/jquery.innerfade.js"></script>
		<script type="text/javascript">
	   $(document).ready(
				function(){
					$('#news').innerfade({
						animationtype: 'slide',
						speed: 750,
						timeout: 3000,
						type: 'random',
						containerheight: '1em'
					});
					
					$('ul#portfolio').innerfade({
						speed: 2000,
						timeout: 5000,
						type: 'sequence',
						containerheight: '245px'
					});
					
					$('.fade').innerfade({
						speed: 1000,
						timeout: 6000,
						type: 'random_start',
						containerheight: '1.5em'
					});
					
					$('.adi').innerfade({
						speed: 'slow',
						timeout: 5000,
						type: 'random',
						containerheight: '150px'
					});

			});
  	</script>
 
 <link rel="stylesheet" href="ressources/css/reset.css"  type="text/css" media="all" />
		<!-- <link rel="stylesheet" href="ressources/css/fonts.css"  type="text/css" media="all" /> -->
		<style type="text/css" media="screen, projection">
					@import url(ressources/css/jq_fade.css);
		</style>	
		
		
	<ul id="portfolio">	
					
					<li>
					
				  		<a href="#"><img src="ressources/images/logoggi.jpg" title="www.ggi.com" class="imgeGrand" /></a>
				  		
				  		</li>
	
					<li>
						<a href="#"><img src="ressources/images/case1.jpg"  class="imgeGrand" /></a>
					
					</li>					
					<li>
						<a href="#"><img src="ressources/images/km.jpg"  class="imgeGrand" /></a>
					</li>
					<li>
						<a href="#"><img src="ressources/images/imf3.jpg"  class="imgeGrand" /></a>
					</li>					
					<li>
						<a href="#"><img src="ressources/images/rt_arch.jpg" class="imgeGrand"/></a>
					</li>
					<li>
						<a href=#"><img src="ressources/images/imf3.jpg"  class="imgeGrand" /></a>
					</li>		
					<li>
						<a href="#"><img src="ressources/images/tuev.jpg"  class="imgeGrand"/></a>
					</li>	
	</ul>

