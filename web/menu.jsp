<div id='cssmenu'>
	<ul>
		<c:if test="${gost == null && menadzerRestorana == null && menadzerSistema == null}">
		
			
			   <li class='has-sub'><a href='#'><span>Logovanje</span></a>
				  <ul>
				 <li>
				 	<a href='login_gost.jsp'><span>Logovanje Korisnika</span></a>
				 </li>
				 <li>
				 	<a href='login_menadzer_restorana.jsp'><span>Logovanje menadzera restorana</span></a>
				 </li>
				 <li class='last'>
				 	<a href='login_menadzer_sistema.jsp'><span>Logovanje menadzera sistema</span></a>
				 </li>
			  </ul>
		    </li>
		</c:if>
		
		
		<c:if test="${gost != null}"  >
				<li><a href='PrikazRestoranaServlet'><span>Restorani</span></a></li>
				<li><a href='PrijateljiPrijateljiServlet'><span>Prijatelji</span></a></li>
				
			<li class='has-sub'><a href='#'><span>Moj Nalog</span></a>
				  <ul>
				 <li>
				 	<a href='MojNalogServlet'><span>Moj profil</span></a>
				 </li>
				 <li>
				 	<a href='MojeRezervacijeServlet'><span>Moje rezervacije</span></a>
				 </li>
				 <li class='last'>
				 	<a href='PrikazPosecenihRestoranaServlet'><span>Poseceni restorani</span></a>
				 </li>
			  </ul>
		    </li>
		    
		    <li><a href='OdjavaServlet'><span>Odjava</span></a></li>
		</c:if>
		
		<c:if test="${menadzerRestorana != null}"  >
			<li><a href="PrikazRestoranaServlet?id=${menadzerRestorana.restoran.id_restoran}"><span>Restoran</span></a></li>
			<li><a href='RasporedServlet?id=${menadzerRestorana.restoran.id_restoran}'><span>Konfiguracija Stolova</span></a></li>
			 <li><a href='MojNalogServlet'><span>Moj Nalog</span></a></li>
			 <li><a href='OdjavaServlet'><span>Odjava</span></a></li>	
		</c:if>
		<c:if test="${menadzerSistema != null}"  >
		
			<li class='has-sub'><a href='#'><span>Restorani</span></a>
				<ul>
					 <li>
					 	<a href='PrikazRestoranaServlet'><span>Pregled restorana</span></a>
					 	   
					 </li>
					 <li class='last'>
					 	<a href='DodavanjeRestoranaServlet'><span>Dodavanje restorana</span></a>
					 </li>
				</ul>
		    </li>
		    
		    <li class='has-sub'><a href='#'><span>Menadzeri</span></a>
				<ul>
					 <li>
					 	<a href='PrikazMenadzeraServlet'><span>Pregled menadzera restorana</span></a>
					 </li>
					 <li class='last'>
					 	<a href='DodavanjeMenadzeraServlet'><span>Dodavanje menadzera restorana</span></a>
					 </li>
				</ul>
		    </li>
		
			 <li><a href='MojNalogServlet'><span>Moj Nalog</span></a></li>
			 <li><a href='OdjavaServlet'><span>Odjava</span></a></li>	
			
		</c:if>
		
		
	</ul>
</div>