# PROJEKTNI ZADATAK 

U ovom projektnom zadatku istestirane su neke funkcionalnosti Web aplikacije (Frontend) sa Selenium Web Driverom kao frameworkom za automatsko testiranje programske podrške.
Web aplikacija koja je testirana je Webshop https://www.bookdepository.com. 
Pri testiranju korišteni su Java Development Kit, integrirano razvojno okruženje IntelliJ i WebDriverManager (Chrome driver i Opera driver).

Napravljena je klasa BookDepositoryTest koja sadrži 5 testova, BeforeMethod i AfterMethod.

BeforeMethod postavlja drivere (Chrome i Opera) i priprema Web aplikaciju za izvođenje testova, ona se izvršava prije svakog testa.
AfterMethod zatvara preglednik, ona se izvršava nakon svakog testa.

Testovi su:
1. bookSearchTest - Provjerava funkcionalnost searchbox-a.
2. checkoutTest - Provjerava radi li checkout ispravno.
3. changeCurrencyTest - Provjerava radi li promjena valute ispravno.
4. filterBestsellersTest - Provjerava filtriranje Bestseller knjiga na knjige ispod €15.
5. advancedSearch - Provjerava funkcionalnost Advanced Search-a tako da se pretražuju knjige po izdavaču.

Također su napravljene klase za svaku stranicu u aplikaciji u kojima se nalaze atributi i metode koje se odrađuju na toj stranici te se one pozivaju u testnim metodama u klasi BookDepositoryTest. Klase čiji se objekti stvaraju pri izvođenju testova su: BookDepositoryAdvancedSearchPage, BookDepositoryBasketPage, BookDepositoryBestsellerPage, BookDepositoryCheckoutPage, BookDepositoryHomePage, BookDepositoryItemPage i BookDepositorySearchPage.

Kako bi se omogućilo testiranje u kraćem vremenu provodi se paralelno testiranje u Chrome-u i Operi, pri čemu se koristi WebDriverManager. Paralelno testiranje je omogućeno u testng.xml.
