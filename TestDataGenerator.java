import java.sql.*;
import java.util.Random;


public class TestDataGenerator {

	public static void main(String[] args) {
		
		try {
			  //conection info 
		      Class.forName("com.mysql.jdbc.Driver");
		      String database = "jdbc:mysql://sql11.freemysqlhosting.net:3306/";
		      String user = "sql11213547";
		      String pass = "xCmX9tm7ku";

		      // establish connection to database
		      Connection con = DriverManager.getConnection(database, user, pass);
		      Statement stmt = con.createStatement();
		      
		      String InsertTableSQL ="INSERT INTO person (ID,EMAIL,LOCATION,CITY,COUNTRY,COLLEGE, WEBSITE, BIO, LASTNAME, FIRSTNAME)VALUES(?,?,?,?,?,?,?,?,?,?)";
		      PreparedStatement prpSt = con.prepareStatement(InsertTableSQL);
		      
		      String email[] = {"cmosen0@dmoz.org", "tjordeson1@bluehost.com", "tcropp2@pbs.org", "jsotworth3@miitbeian.gov.cn",
		    		  "jroskell4@google.fr", "jupex5@omniture.com", "ncapstick6@examiner.com", "ihalliberton7@skype.com", "lbrownstein8@mapy.cz", "gstanmer9@ted.com", "tgrimleya@plala.or.jp", "ebroskeb@goo.gl", "lledstonec@blogger.com", "afydod@devhub.com", "mbennoee@youtu.be", "bakisterf@intel.com", "gcresarg@webs.com", "fhelmh@wikimedia.org", "bjaskiewiczi@sohu.com",
		    		  "nwannanj@google.cn", "lcarlozzik@sitemeter.com", "csonleyl@sun.com", "kwadforthm@imgur.com", "chourihanen@paypal.com", 
		    		  "hattwoulo@whitehouse.gov", "ebonsallp@elegantthemes.com", "sgavanq@about.com", "bguietr@dell.com", "cferdinands@biglobe.ne.jp", "gwitherst@topsy.com", "aboleynu@a8.net", "trichesv@nsw.gov.au", "lsandw@addthis.com", "bthreadgillx@bandcamp.com",
		    		  "rfriedenbachy@hp.com", "tdarmodyz@dailymail.co.uk", "mmacelholm10@go.com", "vokelly11@discovery.com", "rmanuelli12@unblog.fr", "gscutts13@blogs.com", "ttrynor14@npr.org", "mdarlaston15@bloomberg.com", "hcongrave16@google.com.au", "awardington17@tripadvisor.com",
		    		  "hvanderlinde18@sciencedaily.com", "anewland19@go.com", "cchapelle1a@meetup.com", "pnunson1b@discovery.com", "llafferty1c@fc2.com", "zepton1d@xrea.com", "wcaudelier1e@cargocollective.com", "hcranny1f@livejournal.com", "ahabbeshaw1g@ifeng.com", "mcosgrive1h@google.co.uk", "ctorrejon1i@twitpic.com", "nbleibaum1j@biblegateway.com", "dcolquete1k@time.com", 
		    		  "kcardenas1l@ebay.com", "mdearth1m@is.gd","wshrubb1o@spotify.com", "fwimlett1p@hp.com", "mblampied1q@mtv.com",
		    		  "lkleisle1r@cnet.com", "vdurran1s@google.it", "ckoschek1t@angelfire.com", "awitson1u@cornell.edu", "fmcgrudder1v@wsj.com", "sadlard1w@canalblog.com", "smaplethorpe1x@topsy.com", "dingliby1y@rakuten.co.jp", "fsoans1z@google.com", "lhambleton20@zdnet.com", "qtomisch21@addthis.com", "rloomis22@eepurl.com", "nkalkhoven23@issuu.com", "syouson24@goo.ne.jp", "lmangeot25@nhs.uk",
		    		  "amachen26@abc.net.au", "cconfait27@flickr.com", "rducker28@ox.ac.uk", "pelliff29@topsy.com",
		    		  "cjenkinson2a@cnbc.com", "bfrusher2b@addtoany.com", "mfaulks2c@naver.com", "sharrowsmith2d@alexa.com", "mpirri2e@hao123.com", "schatband2f@dell.com", "wpetasch2g@xing.com", "msharland2h@bandcamp.com", "ddewen2i@naver.com", "bebbles2j@livejournal.com", "tdewfall2k@wunderground.com", "fimore2l@list-manage.com", "avernazza2m@scribd.com", "jsonley2n@amazonaws.com", 
		    		  "ndecroix2o@joomla.org", "phaysham2p@hc360.com", "mhazleton2q@xinhuanet.com", "pdemchen2r@statcounter.com"
		      };
		      String location[] = {"Texas", "Oregon", "Pennsylvania", "Texas", "Michigan", "Tennessee",
		    		  "District of Columbia", "Florida", "Ohio", "Georgia", "Pennsylvania", "District of Columbia", "Virginia", "Illinois", "California", "Michigan", "Kansas", "Texas", "Nevada", "California", "Florida", "Louisiana", "California", "Pennsylvania", "Georgia", "Ohio", "California", "Nevada",
		    		  "Florida", "Texas", "Michigan", "Florida", "North Carolina", "District of Columbia", "Georgia", "Massachusetts", "Pennsylvania", "Nebraska", "Delaware", "Nevada", "Florida", "Louisiana", "California", "Pennsylvania", "Texas", "Florida", "Florida", "California", "California", "California", "Massachusetts", "Indiana", "Illinois", "North Carolina", "Wyoming",
		    		  "Minnesota", "New York", "District of Columbia", "Nebraska", "California",
		    		  "Massachusetts", "California", "District of Columbia", "Tennessee", "South Carolina", "Virginia", "Alabama", "Alabama", "South Carolina", "Ohio", "Connecticut", "Missouri", "New Jersey", "Michigan", "Ohio", "Florida", "Virginia", "Georgia", "Nevada", "Pennsylvania", "Texas", "Massachusetts", "North Carolina", "Louisiana", "Nevada", "Mississippi", "California", "Florida",
		    		  "North Carolina", "Connecticut", "Arizona", "District of Columbia",
		    		  "Minnesota", "South Carolina", "California", "Arizona", "District of Columbia", "New York", "Florida"
		      };
		      String city[] = {"Datarsitu", "San Martín", "Wangge’ertang", "Bełk", "Sakrand", "Zhong’an", "Fresno", "Calimete", "Могила", "Minneapolis", "Peristerona", "Sai’erlong Xiang", "Luoxi", "Wang Hin", "Velasco Ibarra", "Uryupinsk", "Tash-Kumyr",
		    		  "Pagnag", "Reno", "Ku‘aydinah", "Posedarje", "Birsa", "Końskowola", "Huafeng", "Edissiya","Yungaisi", "Greensboro", "Arkalyk", "Owen Sound",
		    		  "Gornorechenskiy", "Raymond", "San Pablo", "Teryayevo", "Lazaro Cardenas",
		    		  "Houbai","Sukabatu","Reforma","Strängnäs","Oyonnax","Bagong", "Sikat","Morales", "Salamanca", "Xiaochi", "Dawuhan", "Tongbang", "Hujiaying", "Lauro de Freitas", "Covas", "Rychvald", "Qingfeng", "Pokhara", "Lille", "Bayanhongor", "Ryazanskiy", "El Cuy", "Liuge", "Kabūdarāhang", "Infantas", "Jīwani",
		    		  "Łanięta", "Pitrufquén", "Ponta da Garça", "Gegu", "Żórawina", "Liugong", "Sydney", "Rungis", "Lyublino", "Pinggirsari", "Fushë-Muhurr", "Molodohvardiys’k", "Mizque", "Tampere",
		    		  "Kourou", "Cibeureum", "Bukovec",
		    		  "Sikur", "Rochester", "Tiberias", "Sīrīs", "Itanhaém", "Yunluo", "Chongjin", "Mölndal", "Ruoqiang", "Buđanovci", "Odeleite", "Waipawa", "Ma’an", "Basiao",
		    		  "Sérifos", "Aţ Ţīrah", "Minakuchi", "Zhouxi", "Lidong", "Cubatão", "Sundbyberg", "Sernur", "Mora", "Berlin", "Vienna", "London", "Timisoara"
		      };
		      String country[] = {"China", "Japonia", "USA", "Germany", "Austria", "Poland", "Romania", "UK", "Russia", "Serbia", "Bulgaria", "France", "Belgium", "Philippine", "Mexico", "Canada", "Spain", "Italy", "Grecee"
		      };
		      String college[] = {"Uni Wine", "TU Wien", "FH Wien", "TU Munich", "Capitol University","Tainan National College of the Arts", "Beirut Arab University", "New Jersey City University", "John Carroll University",
		    		  "Mehrabyan Medical Institute and Medical College", "University of Uyo",
		    		  "Unity College", "University of Malawi", "Oklahoma Baptist University",
		    		  "Jobu University", "Silesian School of Economics and Languages", "SRM Institute Of Science & Technology ( Deemed University)", "Kazan State University of Medicine", "Lincoln Memorial University", 
		    		  "European College of Liberal Arts", "Patna University", "University of Central Missouri", "Heritage College", "Cyberjaya University College of Medical ScienceC", "Western University", "Gulf University College", "University of Sarajevo"
		      };
		      String website[] = {"sina.com.cn", "examiner.com", "fastcompany.com", "businessinsider.com", "zimbio.com", "examiner.com", "mozilla.org", "symantec.com", "photobucket.com", "tiny.cc", "kickstarter.com", "bravesites.com", "imdb.com", "geocities.jp", "ycombinator.com", "digg.com", "istockphoto.com",
		    		  "opensource.org", "tinyurl.com", "lycos.com", "microsoft.com", "livejournal.com", "vimeo.com", "paypal.com", "hud.gov", "mlb.com", "narod.ru", "t-online.de", "psu.edu", "yahoo.co.jp", "sbwire.com", "indiatimes.com", "toplist.cz", "a8.net", "epa.gov", "prnewswire.com", "nbcnews.com", "ihg.com", 
		    		  "hc360.com", "newyorker.com", "simplemachines.org", "cbslocal.com", "infoseek.co.jp", "goo.ne.jp", "t-online.de", "auda.org.au", "chronoengine.com", "theglobeandmail.com", 
		    		  "loc.gov", "ftc.gov", "sogou.com", "studiopress.com", "bizjournals.com", "gmpg.org", "shareasale.com", "networksolutions.com", "qq.com", "about.com", "who.int", "rediff.com",
		    		  "storify.com", "flavors.me", "latimes.com", "businessweek.com", "photobucket.com", "ask.com", "weebly.com", "deliciousdays.com"
		      };
		      String bio[] = {"Profound composite protocol", "Enhanced attitude-oriented methodology", "Stand-alone exuding task-force", "Adaptive heuristic policy", "Mandatory full-range success", "Horizontal object-oriented standardization", "Ergonomic needs-based productivity", "Re-contextualized maximized success",
		    		  "Triple-buffered tangible time-frame", "Face to face object-oriented frame", "Proactive well-modulated task-force", "Reactive full-range internet solution","Balanced multi-tasking Graphical User Interface",
		    		  "Cross-group upward-trending matrices", "Sharable global support", "Multi-tiered zero tolerance system engine", "Intuitive attitude-oriented firmware", "Synergistic explicit matrices", "Re-engineered real-time paradigm", "Fundamental national portal", "Switchable systemic groupware", 
		    		  "Triple-buffered multi-tasking instruction set", "Synergistic actuating system engine", "Optimized bottom-line internet solution", "Cross-group next generation knowledge user", "Persevering tangible focus group", "Extended non-volatile encryption", "Optimized upward-trending framework",
		    		  "Face to face client-driven leverage", "Devolved discrete hardware", "Open-source systematic emulation", "Realigned intermediate architecture", "Phased attitude-oriented middleware", "Open-source fault-tolerant matrices", "Ameliorated contextually-based array", "Fully-configurable bifurcated encryption",
		    		  "Horizontal client-driven algorithm", "Assimilated attitude-oriented ability", "Horizontal homogeneous synergy", "Fully-configurable non-volatile methodology", "Synchronised static forecast", "Triple-buffered coherent software", "Right-sized 3rd generation structure", "Organic eco-centric model", 
		    		  "Open-source encompassing project", "Robust uniform challenge", "Proactive zero tolerance artificial intelligence", "Ergonomic solution-oriented flexibility", "Right-sized cohesive help-desk", "Team-oriented solution-oriented throughput", "Versatile maximized service-desk", "Profit-focused disintermediate policy",
		    		  "Adaptive well-modulated flexibility", "Down-sized neutral algorithm", "Function-based multimedia artificial intelligence", "Secured directional forecast", "Re-contextualized grid-enabled website", "Digitized bifurcated Graphic Interface", "Virtual content-based task-force", "Reactive zero defect benchmark", 
		    		  "Up-sized object-oriented benchmark", "Streamlined eco-centric functionalities",  "Extended global monitoring", "Optional logistical process improvement", "Devolved demand-driven support", "Automated mobile portal", "Organic 24 hour flexibility", "Quality-focused optimizing infrastructure", "Assimilated object-oriented access", 
		    		  "Secured heuristic definition", "User-friendly human-resource contingency", "Function-based non-volatile application", "Multi-layered asynchronous encoding", "Realigned static circuit", "Face to face clear-thinking utilisation", "Networked even-keeled task-force", "Devolved real-time alliance", "Networked systematic challenge", 
		    		  "Enterprise-wide disintermediate toolset", "Multi-layered 4th generation hub"
		      };
		      String lastname[] = {"Crake", "Rymmer",
		    		  "Harvey", "Quin", "Ledekker" , "De Gregoli", "Leak", "Bartali", "Laraway", "Brislan", "Bugge", "Amy", "Pydcock", "Symers", "Shakle", "Paolucci", "Pincott", "Bagster", "Lascell", "Eager", "Casperri", "Atrill", "Thrift", "Boggas", "Sorley", "Gally", "de Aguirre",
		    		  "Mullany", "Mulderrig", "Meah", "Juden", "Dyment", "Kellog", "Aggas", "Marler", "Boaler", "Karp", "Yendall", "Mitchelmore", "McKeurtan", "Westwell", "Blockey", "Crampton", "Petters", "Redmile", "Douty", "Fears", "Gannon", "Bradd", "Rottery", "Aucourte", "Chattock", "Kiefer", "Goodlet", "Screeton", "Varndell",
		    		  "Jirasek", "Jimmes", "Durrans", "Eadie", "Olyunin", "Vedeshkin", "Ubsdall", "Jorgensen", "Ziemke", "Tsar", "Oles", "Tugman", "Jarlmann", "Larkings", "Monck", "Ryson", "Muffin", "Shovlin", "Cansfield", "Dyneley",
		    		  "Mandel", "Dufton", "Bramont", "Zannuto", "Figgs", "McGillacoell", "OHanvey", "Burtwistle", "Ginnane", "Northen", "Fowells", "Purcer", "Godsafe", "Cerith", "Marklund", "Jirzik", "Getsham", "Oxby", "Soden", "Goldberg", "Britzius", "Bech", "Tomaszkiewicz", "Yurkevich", "McCome", "Dear", "Bransom", "Lukesch"
		      };
		      String firstname[] = {"Justen", "Colin", "Anne", "Shayne", "Magnus","Brooke", "Maxie","Markus", "Jaclyn", "Casimer", "Eino", "Abbigail", "Euna", "Eden", "Domenic", "Jayda", "Matt", "Novella", "Dayne", "Aiyana", "Marion", "Henri", "Christine","Adrien", "Jensen", "Oma", "Maud", "Napoleon", "Roma", "Emily", "Lauretta", "Christian", 
		    		  "Ava", "Garth", "Kenton", "Harmony", "Harry", "Horace", "Jessika", "Maiya", "Beth", "Verona", "Hulda", "Alison", "Mohammed", "Donato", "Asia", "Rosamond", "Tad", "Milton", "Wayne", "Patricia", "Ozella", "Camille", "Marcia", "Nina", "Francis", "Elody", "Esther", "Margarette", "Athena", "Araceli", "Buddy", "Simone", "Frida",
		    		  "Murl", "Spencer", "Jacklyn", "Garrison", "Jaeden", "Aliza", "Morris", "Deven", "Nick", "Jacklyn", "Jesus", "Cesar", "Icie", "Shirley", "Zackary", "Morris", "Reece", "Tyson", "Meta", "Jan", "Hilario", "Albert", "Hilma", "Nayeli", "Shawn", "Keenan", "Jaylan", "Donnie", "Stacey", "Judah"
		      };
		      
		      String InsertTableSQL2 = "INSERT INTO user(ID, JOINDATE, USERNAME, PASSWORD, PROFILEPICTURE, PERSONID) VALUES (?,?,?,?,?,?)";
		      PreparedStatement prpSt2 = con.prepareStatement(InsertTableSQL2);
		      
		      String joinDate[] = {"5/3/1989", "9/21/2001", "7/13/2008", "5/3/2000", "5/17/1993", "11/26/2008", "6/16/1990", "11/17/2011", "6/21/1997", "4/24/1990", "2/12/2003", "6/8/1982", "12/26/2002", "10/5/1989", "8/20/2012", "2/2/2001", "9/26/1992", "9/4/1991", "8/28/1994", "11/17/2013", "10/5/1996", "4/8/2010", "9/25/1990", "10/12/2016", "5/18/2003", "4/29/1990",
		    		  "9/9/1986", "11/2/1998", "11/29/2002", "5/21/1997", "6/24/2008", "11/1/2017", "9/20/1983", "9/11/1995", "12/25/2005", "4/23/1987", "2/7/2002", "7/28/2006", "10/2/1990", "3/9/2001", "6/14/2013", "8/1/1984", "5/23/2017", "7/6/2007", "7/23/2011", "8/13/2014", "9/4/2001", "9/7/2005", "4/30/1988", "6/8/2002",
		    		  "10/18/2010", "3/3/1990", "3/16/1992", "6/22/2017", "1/25/2004", "2/3/2000", "12/31/1982", "10/6/1986", "9/27/1994", "4/11/1990", "9/6/1996", "11/10/2002", "2/7/2009", "11/11/1982", "2/11/1988", "2/9/2004", "5/23/1990", "2/10/2007", "2/2/1984", "5/23/2011"
};
		      String username[] = {"Florian", "Gay.Johnson", "Damion_Corkery", "Gaylord", "Jovany.Huels", "Elmo", "Lempi", "Gavin.Lehner", "Elisa", "Dane.Walter", "Ward", "Rubie.Hoeger", "Astrid", "Malachi_Stiedemann", "Nikki.Brakus", "Ernest", "Shania.Rutherford", "Bernardo", "Benedict.Treutel", "Sid", "Lowell.Grady", "Marilyne.Wolff", "Charlotte_Schmidt", "Mohammed_Kuphal",
		    		  "Kaci_Schaefer", "Keeley.Stracke", "Nia", "Madilyn", "Florence", "Gertrude.Funk", "Adrien", "Jazmyn", "Consuelo", "Reece.Stiedemann", "Eino", "Vicenta_Zemlak", "Florine_Toy", "Gracie", "Brent", "Keira_Rodriguez", "Chasity.Jerde", "Jorge", "Darien.Kerluke", "Theresa", "Ruth", "Joanie", "Tod", "Stevie", "Fleta_Bergnaum", "Rasheed_Schiller", "Jammie.Jast",
		    		  "Milford", "Stuart", "Candido.Kohler", "Cyrus.Brown", "Christine.Kautzer", "Candido", "Marcus_Langworth", "Noel.Schumm", "Olin", "Brannon.Krajcik", "Daron", "Bridgette.Kilback", "Nash", "Rashad.Halvorson", "Orval", "Joany.Ondricka", "Albina_Reinger", "Lamont", "Estell", "Edward", "Mekhi.Schowalter", "Efrain.Schaden", "Dewayne", "Flo", "Tristian_Schneider",
		    		  "Janae", "Domenic", "Kamryn", "Jasper", "Katelin", "Carlee.Ritchie", "Randal", "Lelah", "Mariah", "Alfreda", "Sally", "Michel.Kuhn", "Katlyn", "Lauretta_Sporer", "Carey.Hane", "Germaine", "Sally_Strosin", "Hermina_O'Reilly", "Weston_Tillman", "Celia",  "Garrison.Olson", "Gust.Ernser", "Dianna.Ankunding", "Lizeth"
		      };
		      String password[] = {"Texas", "Oregon", "Pennsylvania", "Texas", "Michigan", "Tennessee",
		    		  "District of Columbia", "Florida", "Ohio", "Georgia", "Pennsylvania", "District of Columbia", "Virginia", "Illinois", "California", "Michigan", "Kansas", "Texas", "Nevada", "California", "Florida", "Louisiana", "California", "Pennsylvania", "Georgia", "Ohio", "California", "Nevada",
		    		  "Florida", "Texas", "Michigan", "Florida", "North Carolina", "District of Columbia", "Georgia", "Massachusetts", "Pennsylvania", "Nebraska", "Delaware", "Nevada", "Florida", "Louisiana", "California", "Pennsylvania", "Texas", "Florida", "Florida", "California", "California", "California", "Massachusetts", "Indiana", "Illinois", "North Carolina", "Wyoming",
		    		  "Minnesota", "New York", "District of Columbia", "Nebraska", "California",
		    		  "Massachusetts", "California", "District of Columbia", "Tennessee", "South Carolina", "Virginia", "Alabama", "Alabama", "South Carolina", "Ohio", "Connecticut", "Missouri", "New Jersey", "Michigan", "Ohio", "Florida", "Virginia", "Georgia", "Nevada", "Pennsylvania", "Texas", "Massachusetts", "North Carolina", "Louisiana", "Nevada", "Mississippi", "California", "Florida",
		    		  "North Carolina", "Connecticut", "Arizona", "District of Columbia",
		    		  "Minnesota", "South Carolina", "California", "Arizona", "District of Columbia", "New York", "Florida"
		      };
		      String profilePicture[] = {"http://dummyimage.com/201x145.png/cc0000/ffffff", "http://dummyimage.com/237x148.png/dddddd/000000", "http://dummyimage.com/112x157.bmp/5fa2dd/ffffff", "http://dummyimage.com/131x205.bmp/ff4444/ffffff", "http://dummyimage.com/219x248.png/5fa2dd/ffffff", "http://dummyimage.com/245x135.jpg/5fa2dd/ffffff", 
				    	"http://dummyimage.com/171x235.bmp/dddddd/000000", "http://dummyimage.com/189x221.png/ff4444/ffffff", "http://dummyimage.com/169x228.png/5fa2dd/ffffff", "http://dummyimage.com/139x195.jpg/cc0000/ffffff", "http://dummyimage.com/248x203.bmp/cc0000/ffffff", "http://dummyimage.com/228x170.jpg/5fa2dd/ffffff", "http://dummyimage.com/155x195.png/dddddd/000000",
				        "http://dummyimage.com/145x211.jpg/ff4444/ffffff", "http://dummyimage.com/133x243.bmp/cc0000/ffffff", "http://dummyimage.com/138x165.png/dddddd/000000", "http://dummyimage.com/110x201.bmp/5fa2dd/ffffff", "http://dummyimage.com/234x228.jpg/cc0000/ffffff", "http://dummyimage.com/234x131.bmp/dddddd/000000", "http://dummyimage.com/246x113.png/cc0000/ffffff", 
				    	"http://dummyimage.com/137x163.png/5fa2dd/ffffff", "http://dummyimage.com/112x151.jpg/ff4444/ffffff", "http://dummyimage.com/187x211.png/ff4444/ffffff", "http://dummyimage.com/109x210.png/cc0000/ffffff", "http://dummyimage.com/222x230.jpg/dddddd/000000", "http://dummyimage.com/179x214.jpg/ff4444/ffffff", "http://dummyimage.com/166x118.jpg/cc0000/ffffff",
				    	"http://dummyimage.com/123x227.png/cc0000/ffffff", "http://dummyimage.com/214x245.png/cc0000/ffffff", "http://dummyimage.com/133x211.png/ff4444/ffffff", "http://dummyimage.com/192x178.png/cc0000/ffffff", "http://dummyimage.com/123x114.bmp/dddddd/000000", "http://dummyimage.com/203x156.png/cc0000/ffffff", "http://dummyimage.com/198x205.bmp/cc0000/ffffff", 
				    	"http://dummyimage.com/236x136.bmp/5fa2dd/ffffff", "http://dummyimage.com/106x220.bmp/ff4444/ffffff", "http://dummyimage.com/235x167.bmp/ff4444/ffffff", "http://dummyimage.com/183x141.png/dddddd/000000", "http://dummyimage.com/149x211.bmp/ff4444/ffffff", "http://dummyimage.com/179x102.jpg/dddddd/000000", "http://dummyimage.com/213x214.bmp/5fa2dd/ffffff", 
				    	 "http://dummyimage.com/144x244.png/5fa2dd/ffffff", "http://dummyimage.com/151x217.jpg/5fa2dd/ffffff", "http://dummyimage.com/198x141.png/5fa2dd/ffffff", "http://dummyimage.com/237x203.png/cc0000/ffffff", "http://dummyimage.com/137x104.png/ff4444/ffffff",
				    	  "http://dummyimage.com/234x159.bmp/ff4444/ffffff", "http://dummyimage.com/139x189.png/ff4444/ffffff", "http://dummyimage.com/111x148.png/5fa2dd/ffffff", "http://dummyimage.com/153x156.jpg/dddddd/000000"
		      };
		      
		      String InsertTabelSQL3 = "INSERT INTO track(ID, NAME, ARTIST, YEAR, ALBUM) VALUES (?,?,?,?,?)";
		      PreparedStatement prpSt3 = con.prepareStatement(InsertTabelSQL3);
		      
		      String name[] = {"Phantasm III: Lord of the Dead", "Igor", "Macbeth", "Russia House, The", "How Do You Know", "Dans la peau d'une grande", "Necessary Death, A", "Under Capricorn", "Terkel in Trouble", "God Save the King", "Dolly and Her Lover", "Come and Get It", "The Forgotten Space", "Road Warrior, The (Mad Max 2)", "Antibodies", "(A)sexual", "Sky West and Crooked (Gypsy Girl) ",
		    		  "Tu£sday", "David and Bathsheba", "Seventh Veil, The", "Hereafter", "Mélo", "Life of Crime", "File on Thelma Jordan, The", "Sweetie", "Devil's Playground", "The Last Gladiators", "Soul Food", "Goebbels Experiment, The", "Amazing Grace", "Full Speed", "Undertaker and His Pals, The", "Christmas Carol, A", "Outbreak", "All's Well", "Chennai Express", "Kites", "Boondock Saints II: All Saints Day, The",
		    		  "Secret of Santa Vittoria, The", "Death by China ", "Long Dark Hall, The", "Secrets & Lies", "Lone Ranger, The", "Alien", "Rembrandt", "Bolero (Uns et les autres, Les)", "Devil Hunter", "PCU", "White Banners", "My Favorite Wife", "Auntie Mame", "Go for It", "Nenette and Boni", "Juan of the Dead", "Ocean's Eleven", "I Have Found It", "First Shot", "Dr. Otto and the Riddle of the Gloom Beam", "Our Family Wedding",
		    		  "Shaolin Wooden Men", "Bury My Heart at Wounded Knee", "Purgatory", "Transformers", "Sergeant Körmy and the South Pacific", "Walk in the Sun, A", "Hipsters (Stilyagi) ", "Let's Not Keep in Touch! ", "Wer", "Forger, The", "Starving Games, The", "Liberty", "Place Beyond the Pines, The", "Man of Steel", "Who Are you Polly Maggoo (Qui êtes-vous, Polly Maggoo?)", "Feast II: Sloppy Seconds", "Post Tenebras Lux", 
		    		  "Boy Meets Girl", "Saludos Amigos", "Yu-Gi-Oh! ", "Private School", "Multiplicity", "Wagon Master", "Visitors, The", "Idiot Returns, The (Návrat idiota)", "Kiss of the Damned", "Evidence", "Locked Out (Enfermés dehors) ", "Narrow Margin"
		      };
		      String artist[] = {"Berge-Halvorson", "Wunsch, Bailey and Harris", "Kris-Crooks", "Mante, Mayer and Reinger", "Huel, Bednar and White", "Welch-Carroll", "Hintz Group", "Kunde-Torp", "Bode, Ernser and Sawayn", "Watsica-Cummerata", "Bode-Beatty", "Reichel, Nader and Barton", "Schmeler, McClure and Rohan", "Turcotte, Aufderhar and Collins", "Breitenberg-Sanford",
		    		  "Smitham Inc", "Gerhold Inc", "O'Hara, Ward and Hackett", "Hand and Sons", "King, McCullough and Schumm", "Kassulke and Sons", "Strosin-Bauch", "Bahringer, Jakubowski and Hoppe", "Haag-Lind", "Runolfsdottir, Wyman and Hermiston", "Sporer, Ortiz and Halvorson", "Johns-Bruen", "Luettgen, Douglas and Terry", "Bernier, Toy and Nikolaus", "Jacobs LLC"
		      };
		      String album[] = {"incremental", "Virtual", "Balanced", "Operative", "Re-contextualized", "Centralized", "data-warehouse", "application", "throughput", "human-resource", "utilisation", "firmware", "5th generation", "interactive", "synergy", "user-facing", "interface", "attitude", "Switchable", "architecture", "foreground", "Cross-group", "Public-key", "intangible",
		    		  "project", "heuristic", "architecture", "Organized", "hardware", "complexity", "Fully-configurable", "system engine", "demand-driven", "approach", "motivating", "didactic", "attitude", "grid-enabled", "Robust", "conglomeration", "migration", "time-frame", "Synergistic", "upward-trending", "algorithm", "bottom-line", "Cloned", "knowledge user", "Business-focused",
		    		  "well-modulated", "Synergistic", "high-level", "circuit", "system engine", "Persevering", "Realigned", "asymmetric", "radical", "optimizing", "Re-engineered","national"
		      };
		      
		      String InsertTabelSQL4 = "INSERT INTO playlist (ID, TITLE, DESCRIPTION, COVERPICTURE, HASHTAG, VIEWS, USERID) VALUES (?,?,?,?,?,?,?)";
		      PreparedStatement prpSt4 = con.prepareStatement(InsertTabelSQL4);
		      
		      String title[] = {"Phantasm III: Lord of the Dead", "Igor", "Macbeth", "Russia House, The", "How Do You Know", "Dans la peau d'une grande", "Necessary Death, A", "Under Capricorn", "Terkel in Trouble", "God Save the King", "Dolly and Her Lover", "Come and Get It", "The Forgotten Space", "Road Warrior, The (Mad Max 2)", "Antibodies", "(A)sexual", "Sky West and Crooked (Gypsy Girl) ",
		    		  "Tu£sday", "David and Bathsheba", "Seventh Veil, The", "Hereafter", "Mélo", "Life of Crime", "File on Thelma Jordan, The", "Sweetie", "Devil's Playground", "The Last Gladiators", "Soul Food", "Goebbels Experiment, The", "Amazing Grace", "Full Speed", "Undertaker and His Pals, The", "Christmas Carol, A", "Outbreak", "All's Well", "Chennai Express", "Kites", "Boondock Saints II: All Saints Day, The", "Secret of Santa Vittoria, The", "Death by China ", "Long Dark Hall, The", "Secrets & Lies", "Lone Ranger, The", "Alien", "Rembrandt", "Bolero (Uns et les autres, Les)", "Devil Hunter", "PCU", "White Banners", "My Favorite Wife", "Auntie Mame", "Go for It", "Nenette and Boni", "Juan of the Dead", "Ocean's Eleven", "I Have Found It", "First Shot", "Dr. Otto and the Riddle of the Gloom Beam", "Our Family Wedding", "Shaolin Wooden Men", "Bury My Heart at Wounded Knee", "Purgatory", "Transformers", "Sergeant Körmy and the South Pacific", "Walk in the Sun, A", "Hipsters (Stilyagi) ", "Let's Not Keep in Touch! ", "Wer", "Forger, The", "Starving Games, The", "Liberty", "Place Beyond the Pines, The", "Man of Steel", "Who Are you Polly Maggoo (Qui êtes-vous, Polly Maggoo?)", "Feast II: Sloppy Seconds", "Post Tenebras Lux", "Boy Meets Girl", "Saludos Amigos", "Yu-Gi-Oh! ", "Private School", "Multiplicity", "Wagon Master", "Visitors, The", "Idiot Returns, The (Návrat idiota)", "Kiss of the Damned", "Evidence", "Locked Out (Enfermés dehors) ", "Narrow Margin"
		      };
		      String description[] = {"Profound composite protocol", "Enhanced attitude-oriented methodology", "Stand-alone exuding task-force", "Adaptive heuristic policy", "Mandatory full-range success", "Horizontal object-oriented standardization", "Ergonomic needs-based productivity", "Re-contextualized maximized success",
		    		  "Triple-buffered tangible time-frame", "Face to face object-oriented frame", "Proactive well-modulated task-force", "Reactive full-range internet solution","Balanced multi-tasking Graphical User Interface",
		    		  "Cross-group upward-trending matrices", "Sharable global support", "Multi-tiered zero tolerance system engine", "Intuitive attitude-oriented firmware", "Synergistic explicit matrices", "Re-engineered real-time paradigm", "Fundamental national portal", "Switchable systemic groupware", 
		    		  "Triple-buffered multi-tasking instruction set", "Synergistic actuating system engine", "Optimized bottom-line internet solution", "Cross-group next generation knowledge user", "Persevering tangible focus group", "Extended non-volatile encryption", "Optimized upward-trending framework",
		    		  "Face to face client-driven leverage", "Devolved discrete hardware", "Open-source systematic emulation", "Realigned intermediate architecture", "Phased attitude-oriented middleware", "Open-source fault-tolerant matrices", "Ameliorated contextually-based array", "Fully-configurable bifurcated encryption",
		    		  "Horizontal client-driven algorithm", "Assimilated attitude-oriented ability", "Horizontal homogeneous synergy", "Fully-configurable non-volatile methodology", "Synchronised static forecast", "Triple-buffered coherent software", "Right-sized 3rd generation structure", "Organic eco-centric model", 
		    		  "Open-source encompassing project", "Robust uniform challenge", "Proactive zero tolerance artificial intelligence", "Ergonomic solution-oriented flexibility", "Right-sized cohesive help-desk", "Team-oriented solution-oriented throughput", "Versatile maximized service-desk", "Profit-focused disintermediate policy",
		    		  "Adaptive well-modulated flexibility", "Down-sized neutral algorithm", "Function-based multimedia artificial intelligence", "Secured directional forecast", "Re-contextualized grid-enabled website", "Digitized bifurcated Graphic Interface", "Virtual content-based task-force", "Reactive zero defect benchmark", 
		    		  "Up-sized object-oriented benchmark", "Streamlined eco-centric functionalities",  "Extended global monitoring", "Optional logistical process improvement", "Devolved demand-driven support", "Automated mobile portal", "Organic 24 hour flexibility", "Quality-focused optimizing infrastructure", "Assimilated object-oriented access", 
		    		  "Secured heuristic definition", "User-friendly human-resource contingency", "Function-based non-volatile application", "Multi-layered asynchronous encoding", "Realigned static circuit", "Face to face clear-thinking utilisation", "Networked even-keeled task-force", "Devolved real-time alliance", "Networked systematic challenge", 
		    		  "Enterprise-wide disintermediate toolset", "Multi-layered 4th generation hub"
		    };
		      String coverpicture[] = {"http://dummyimage.com/201x145.png/cc0000/ffffff", "http://dummyimage.com/237x148.png/dddddd/000000", "http://dummyimage.com/112x157.bmp/5fa2dd/ffffff", "http://dummyimage.com/131x205.bmp/ff4444/ffffff", "http://dummyimage.com/219x248.png/5fa2dd/ffffff", "http://dummyimage.com/245x135.jpg/5fa2dd/ffffff", 
				    	"http://dummyimage.com/171x235.bmp/dddddd/000000", "http://dummyimage.com/189x221.png/ff4444/ffffff", "http://dummyimage.com/169x228.png/5fa2dd/ffffff", "http://dummyimage.com/139x195.jpg/cc0000/ffffff", "http://dummyimage.com/248x203.bmp/cc0000/ffffff", "http://dummyimage.com/228x170.jpg/5fa2dd/ffffff", "http://dummyimage.com/155x195.png/dddddd/000000",
				        "http://dummyimage.com/145x211.jpg/ff4444/ffffff", "http://dummyimage.com/133x243.bmp/cc0000/ffffff", "http://dummyimage.com/138x165.png/dddddd/000000", "http://dummyimage.com/110x201.bmp/5fa2dd/ffffff", "http://dummyimage.com/234x228.jpg/cc0000/ffffff", "http://dummyimage.com/234x131.bmp/dddddd/000000", "http://dummyimage.com/246x113.png/cc0000/ffffff", 
				    	"http://dummyimage.com/137x163.png/5fa2dd/ffffff", "http://dummyimage.com/112x151.jpg/ff4444/ffffff", "http://dummyimage.com/187x211.png/ff4444/ffffff", "http://dummyimage.com/109x210.png/cc0000/ffffff", "http://dummyimage.com/222x230.jpg/dddddd/000000", "http://dummyimage.com/179x214.jpg/ff4444/ffffff", "http://dummyimage.com/166x118.jpg/cc0000/ffffff",
				    	"http://dummyimage.com/123x227.png/cc0000/ffffff", "http://dummyimage.com/214x245.png/cc0000/ffffff", "http://dummyimage.com/133x211.png/ff4444/ffffff", "http://dummyimage.com/192x178.png/cc0000/ffffff", "http://dummyimage.com/123x114.bmp/dddddd/000000", "http://dummyimage.com/203x156.png/cc0000/ffffff", "http://dummyimage.com/198x205.bmp/cc0000/ffffff", 
				    	"http://dummyimage.com/236x136.bmp/5fa2dd/ffffff", "http://dummyimage.com/106x220.bmp/ff4444/ffffff", "http://dummyimage.com/235x167.bmp/ff4444/ffffff", "http://dummyimage.com/183x141.png/dddddd/000000", "http://dummyimage.com/149x211.bmp/ff4444/ffffff", "http://dummyimage.com/179x102.jpg/dddddd/000000", "http://dummyimage.com/213x214.bmp/5fa2dd/ffffff", 
				    	 "http://dummyimage.com/144x244.png/5fa2dd/ffffff", "http://dummyimage.com/151x217.jpg/5fa2dd/ffffff", "http://dummyimage.com/198x141.png/5fa2dd/ffffff", "http://dummyimage.com/237x203.png/cc0000/ffffff", "http://dummyimage.com/137x104.png/ff4444/ffffff",
				    	  "http://dummyimage.com/234x159.bmp/ff4444/ffffff", "http://dummyimage.com/139x189.png/ff4444/ffffff", "http://dummyimage.com/111x148.png/5fa2dd/ffffff", "http://dummyimage.com/153x156.jpg/dddddd/000000"
		     };
		      String hashtag[] = {"incremental", "Virtual", "Balanced", "Operative", "Re-contextualized", "Centralized", "data-warehouse", "application", "throughput", "human-resource", "utilisation", "firmware", "5th generation", "interactive", "synergy", "user-facing", "interface", "attitude", "Switchable", "architecture", "foreground", "Cross-group", "Public-key", "intangible",
		    		  "project", "heuristic", "architecture", "Organized", "hardware", "complexity", "Fully-configurable", "system engine", "demand-driven", "approach", "motivating", "didactic", "attitude", "grid-enabled", "Robust", "conglomeration", "migration", "time-frame", "Synergistic", "upward-trending", "algorithm", "bottom-line", "Cloned", "knowledge user", "Business-focused",
		    		  "well-modulated", "Synergistic", "high-level", "circuit", "system engine", "Persevering", "Realigned", "asymmetric", "radical", "optimizing", "Re-engineered","national"
		      };
		    
		      String InsertTabelSQL5 = "INSERT INTO collection (ID, DESCRIPTION, TITLE, USERID, PLAYLISTID) VALUES (?,?,?,?,?)";
		      PreparedStatement prpSt5 = con.prepareStatement(InsertTabelSQL5);
		      
		      String CollectionDescription[] = {"Profound composite protocol", "Enhanced attitude-oriented methodology", "Stand-alone exuding task-force", "Adaptive heuristic policy", "Mandatory full-range success", "Horizontal object-oriented standardization", "Ergonomic needs-based productivity", "Re-contextualized maximized success",
		    		  "Triple-buffered tangible time-frame", "Face to face object-oriented frame", "Proactive well-modulated task-force", "Reactive full-range internet solution","Balanced multi-tasking Graphical User Interface",
		    		  "Cross-group upward-trending matrices", "Sharable global support", "Multi-tiered zero tolerance system engine", "Intuitive attitude-oriented firmware", "Synergistic explicit matrices", "Re-engineered real-time paradigm", "Fundamental national portal", "Switchable systemic groupware", 
		    		  "Triple-buffered multi-tasking instruction set", "Synergistic actuating system engine", "Optimized bottom-line internet solution", "Cross-group next generation knowledge user", "Persevering tangible focus group", "Extended non-volatile encryption", "Optimized upward-trending framework",
		    		  "Face to face client-driven leverage", "Devolved discrete hardware", "Open-source systematic emulation", "Realigned intermediate architecture", "Phased attitude-oriented middleware", "Open-source fault-tolerant matrices", "Ameliorated contextually-based array", "Fully-configurable bifurcated encryption",
		    		  "Horizontal client-driven algorithm", "Assimilated attitude-oriented ability", "Horizontal homogeneous synergy", "Fully-configurable non-volatile methodology", "Synchronised static forecast", "Triple-buffered coherent software", "Right-sized 3rd generation structure", "Organic eco-centric model", 
		    		  "Open-source encompassing project", "Robust uniform challenge", "Proactive zero tolerance artificial intelligence", "Ergonomic solution-oriented flexibility", "Right-sized cohesive help-desk", "Team-oriented solution-oriented throughput", "Versatile maximized service-desk", "Profit-focused disintermediate policy",
		    		  "Adaptive well-modulated flexibility", "Down-sized neutral algorithm", "Function-based multimedia artificial intelligence", "Secured directional forecast", "Re-contextualized grid-enabled website", "Digitized bifurcated Graphic Interface", "Virtual content-based task-force", "Reactive zero defect benchmark", 
		    		  "Up-sized object-oriented benchmark", "Streamlined eco-centric functionalities",  "Extended global monitoring", "Optional logistical process improvement", "Devolved demand-driven support", "Automated mobile portal", "Organic 24 hour flexibility", "Quality-focused optimizing infrastructure", "Assimilated object-oriented access", 
		    		  "Secured heuristic definition", "User-friendly human-resource contingency", "Function-based non-volatile application", "Multi-layered asynchronous encoding", "Realigned static circuit", "Face to face clear-thinking utilisation", "Networked even-keeled task-force", "Devolved real-time alliance", "Networked systematic challenge", 
		    		  "Enterprise-wide disintermediate toolset", "Multi-layered 4th generation hub"
		     };
		      String CollectionTitle[] = {"incremental", "Virtual", "Balanced", "Operative", "Re-contextualized", "Centralized", "data-warehouse", "application", "throughput", "human-resource", "utilisation", "firmware", "5th generation", "interactive", "synergy", "user-facing", "interface", "attitude", "Switchable", "architecture", "foreground", "Cross-group", "Public-key", "intangible",
		    		  "project", "heuristic", "architecture", "Organized", "hardware", "complexity", "Fully-configurable", "system engine", "demand-driven", "approach", "motivating", "didactic", "attitude", "grid-enabled", "Robust", "conglomeration", "migration", "time-frame", "Synergistic", "upward-trending", "algorithm", "bottom-line", "Cloned", "knowledge user", "Business-focused",
		    		  "well-modulated", "Synergistic", "high-level", "circuit", "system engine", "Persevering", "Realigned", "asymmetric", "radical", "optimizing", "Re-engineered","national"
		     };
		      
		      try {
		    	  Random rand =new Random();
		    	  //person
		    	  int personId= 0;
		    	  for(int i= 0; i< 1000; i++) {
		    		  personId ++;
		    		  String saveEmail = email[new Random().nextInt(email.length)];
		    		  String saveLocation = location[new Random().nextInt(location.length)];
		    		  String saveCity = city[new Random().nextInt(city.length)];
		    		  String saveCountry = country[new Random().nextInt(country.length)];
		    		  String saveCollege = college[new Random().nextInt(college.length)];
		    		  String saveWebsite = website[new Random().nextInt(website.length)];
		    		  String saveBio = bio[new Random().nextInt(bio.length)];
		    		  String saveLastname = lastname[new Random().nextInt(lastname.length)];
		    		  String saveFirstname = firstname[new Random().nextInt(firstname.length)];
		    		  
		    		  prpSt.setInt(1,personId);
		        	  prpSt.setString(2,saveEmail);
		        	  prpSt.setString(3,saveLocation);
		        	  prpSt.setString(4,saveCity);
		        	  prpSt.setString(5,saveCountry);
		        	  prpSt.setString(6,saveCollege);
		        	  prpSt.setString(7,saveWebsite);
		        	  prpSt.setString(8,saveBio);
		        	  prpSt.setString(9,saveLastname);
		        	  prpSt.setString(10, saveFirstname);

		        	  prpSt.executeUpdate();
		    	  }
		    	  
		    	  //user
		    	  int userId = 0 ;
		    	  for(int i =0; i< 1000; i++) {
		    		  userId ++;
		    		  String saveJoinDate = joinDate[new Random().nextInt(joinDate.length)];
		    		  String saveUsername = username[new Random().nextInt(username.length)];
		    		  String savePassword = password[new Random().nextInt(password.length)];
		    		  String saveProfilePic = profilePicture[new Random().nextInt(profilePicture.length)];
		    		  int personId1 = rand.nextInt((999-2)+1)+1; //max-min ) + 1 )+ min
		    		  
		    		  prpSt2.setInt(1, userId);
		    		  prpSt2.setString(2, saveJoinDate);
		    		  prpSt2.setString(3, saveUsername);
		    		  prpSt2.setString(4, savePassword);
		    		  prpSt2.setString(5, saveProfilePic);
		    		  prpSt2.setInt(6, personId1);
		    		  
		    		  prpSt2.executeUpdate();
		    	  }
		    	  
		    	  //track
		    	  int trackId = 0;
		    	  for(int i=0; i<2000; i++) {
		    		  trackId ++;
		    		  String saveName = name[new Random().nextInt(name.length)];
		    		  String saveArtist = artist[new Random().nextInt(artist.length)];
		    		  int year = randBetween(1980,2017);
		    		  String saveAlbum = album[new Random().nextInt(artist.length)];
		    		  
		    		  prpSt3.setInt(1, trackId);
		    		  prpSt3.setString(2, saveName);
		    		  prpSt3.setString(3, saveArtist);
		    		  prpSt3.setInt(4, year);
		    		  prpSt3.setString(5, saveAlbum);
		    		  
		    		  prpSt3.executeUpdate();
		    	  }
		    	  
		    	  //play list
		    	  int playListID = 0;
		    	  for(int i = 0; i<500; i++) {
		    		  playListID++;
		    		  String saveTitle = title[new Random().nextInt(title.length)];
		    		  String saveDescription = description[new Random().nextInt(description.length)];
		    		  String saveCoverPicture = coverpicture[new Random().nextInt(coverpicture.length)];
		    		  String saveHashtag = hashtag[new Random().nextInt(hashtag.length)];
		    		  int views = randBetween(0,1000);
		    		  int userId2 = rand.nextInt((999-2)+1)+1;
		    		  
		    		  prpSt4.setInt(1, playListID);
		    		  prpSt4.setString(2, saveTitle);
		    		  prpSt4.setString(3, saveDescription);
		    		  prpSt4.setString(4, saveCoverPicture);
		    		  prpSt4.setString(5, saveHashtag);
		    		  prpSt4.setInt(6,views);
		    		  prpSt4.setInt(7, userId2);
		    		  
		    		  prpSt4.executeUpdate();
		    	  }
		    	  
		    	  //collection
		    	  int collectionID = 0;
		    	  for(int i =0; i< 200; i++) {
		    		  collectionID++;
		    		  String saveDescriptionC = CollectionDescription[new Random().nextInt(CollectionDescription.length)];
		    		  String saveTitleC = CollectionTitle[new Random().nextInt(CollectionTitle.length)];
		    		  int userId3 = rand.nextInt((999-2)+1)+1;
		    		  int playlistID1 = rand.nextInt((499-2)+1)+1;
		    		  
		    		  prpSt5.setInt(1, collectionID);
		    		  prpSt5.setString(2, saveDescriptionC);
		    		  prpSt5.setString(3, saveTitleC);
		    		  prpSt5.setInt(4, userId3);
		    		  prpSt5.setInt(5, playlistID1);
		    		  
		    		  prpSt5.executeUpdate();
		    	  }
		    	  
		      }catch (Exception e) {
		          System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
		      }finally{
		    	  if(prpSt !=null){
		    		  prpSt.close();
		    	  }
		    	  if(prpSt2 !=null){
		    		  prpSt2.close();
		    	  }
		    	  if(prpSt3 !=null){
		    		  prpSt3.close();
		    	  }
		    	  if(prpSt4 !=null){
		    		  prpSt4.close();
		    	  }
		    	  if(prpSt5 !=null){
		    		  prpSt5.close();
		    	  }
		      }
		      //checking the number of inserts for the tables
		      ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM person");
		      if(rs.next()) {
		    	  int count  = rs.getInt(1);
		    	  System.out.println("1000 persons: "+ count);
		      }
		      ResultSet rs1 = stmt.executeQuery("SELECT COUNT (*) FROM user");
		      if(rs1.next()) {
		    	  int count  = rs1.getInt(1);
		    	  System.out.println("1000 users: "+ count);
		      }
		      ResultSet rs2 = stmt.executeQuery("SELECT COUNT (*) FROM track");
		      if(rs2.next()) {
		    	  int count  = rs2.getInt(1);
		    	  System.out.println("2000 tracks: "+ count);
		      }
		      ResultSet rs3 = stmt.executeQuery("SELECT COUNT (*) FROM playlist");
		      if(rs3.next()) {
		    	  int count  = rs3.getInt(1);
		    	  System.out.println("500 playlists: "+ count);
		      }
		      ResultSet rs4 = stmt.executeQuery("SELECT COUNT (*) FROM collection");
		      if(rs4.next()) {
		    	  int count  = rs4.getInt(1);
		    	  System.out.println("200 collections: "+ count);
		      }
		      
		      //clean up connections
		      rs.close();
		      rs1.close();
		      rs2.close();
		      rs3.close();
		      rs4.close();
		      stmt.close();
		      con.close();
		      
		}catch (Exception e) {
		      System.err.println(e.getMessage());
		}
	
	  }
	public static int randBetween(int start, int end) {
	      return start + (int)Math.round(Math.random() * (end - start));
	}
}
