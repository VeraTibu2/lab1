Uppgift 1: Refaktorisera

Gör de förändringar som ni identifierat i del 3, i enlighet med er refaktoreringsplan.

Uppgift 2: Model-View-Controller

Användargränssnittet ni utgick från i del 3 var en ansats till implementation av Model-View-Controller Pattern, men där gränsdragningen mellan model, view, controller och applikation inte var något vidare genomtänkt (för att inte säga usel).

    Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts smartare, dummare eller tunnare?
        -hitta kod som är i fel ställe, t.ex; 
            - move it funktionen (som bör hanteras av Modell) är i Drawpanel.
            -ursprungliga CarController är inte riktigt en controller då den innehåller funktioner som egentligen bör vara i modell. Då kan man se Carcontroller som Modell-klassen istället.
    Vilka av dessa brister åtgärdade ni med er nya design från del 3? Hur då? Vilka brister åtgärdade ni inte?
        -Move it, tog vi bort helt eftersom att vi redan hade logik som hanterade rörelsen på ett MOdell mapp.
        -
    Rita ett nytt UML-diagram som beskriver en förbättrad design med avseende på MVC.


Uppgift 3: Fler designmönster

    Observer, Factory Method, State, Composite. För vart och ett av dessa fyra designmönster, svara på följande frågor:
        Finns det något ställe i er design där ni redan använder detta pattern, avsiktligt eller oavsiktligt? Vilka designproblem löste ni genom att använda det?
        Finns det något ställe där ni kan förbättra er design genom att använda detta design pattern? Vilka designproblem skulle ni lösa genom att använda det? Om inte, varför skulle er design inte förbättras av att använda det?
    Uppdatera er design med de förbättringar ni identifierat.


Uppgift 4: Refaktorisering igen

Implementera slutligen de designförbättringar ni identifierat i alla tidigare uppgifter.


Uppgift 5: Utöka användargränssnittet

Implementera funktionalitet för att lägga till och ta bort bilar via GUI:t. Kan ni implementera detta utan att behöva förändra existerande klassfiler?

    Skapa knappar för "Add car" och "Remove car" med följande funktionalitet:
        "Add car" ska antingen generera en slumpmässig bil eller en given bil.
        "Remove car" ska ta bort någon bil - välj själva hur det avgörs vilken.
        Om inga bilar finns ska "Remove car" inte ha någon effekt, och om det finns 10 bilar ska "Add car" inte ha någon effekt. (OBS: Det måste inte vara just 10 som är gränsen, ni kan sätta en annan siffra om det gör det lättare med upplösningen.)
    Kan något designmönster vara relevant att använda för denna utökning?


Extra uppgifter for mer utmaning (ej betygsatta):
Uppgift 6: Lagg till ny vy

    Skriv ut "<Bil>: <Hastighet>" i något lämpligt hörn av panelen, eller kanske på en helt ny JLabel ni kan lägga under alla knappar. Detta bör göras inte som ett tillägg till den befintliga vyn, utan som en ny vy som kan samexistera med den gamla vyn, existera fristående från den gamla vyn, eller samexistera med helt andra vyer.
    Hur bör eran MVC-lösning vara utformad for att möjliggöra att ovanstående förändring blir en utökning snarare än en modifikation?
    Hur bör de olika komponenterna kommunicera med varandra?


Uppgift 7: Immutability

Gör bilmodellen (men inte användargränssnittet) immutable i görligaste mån. Gör detta utan att programmets observerbara beteende ändras: trots att ett bilobjekt inte kan ändras efter att det skapas, ska användarupplevelsen med bilar som rör sig vara oförändrad. Resonera om för- och nackdelar med att gå olika långt i projektet att göra allt immutable.


Uppgift 8: Diverse

    Gör så att man kan välja vilken bil man vill ta bort genom att markera bilarna, så att de blir "highlightade".
    Gör ett spel av er simulator, komplett med poäng och 2-spelarfunktionalitet.
