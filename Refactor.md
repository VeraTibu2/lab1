## Uppgift 3: Ansvarsområden

#### Analysera era klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP).

#### Vilka ansvarsområden har era klasser?
#### Vilka anledningar har de att förändras?


Det kan vara lämpligt att flytta representationen för riktning upp till Object2D eller en abstrakt klass som representerar
alla Object2D's som kan förflytta sig. Nutida scope lämpar sig dock till att endast vehicle innehåller denna representation.

- Automotive: Beskriver motoriserade fordon och implementerar Movable.

- Cars: Beskriver modellen för personbilar. Implementerar vissa delar av Movable

- Movable: Interfacet movable är ett kontrakt på att tre metoder skall finnas i den implementerade klassen:

Move(), turnLeft(), och turnRight(). Detta interface implementeras delvis i Automotive, men move implementeras av de
slutgiltiga klasserna som inte är abstrakta. Idealt hade varit att ha generiska metoder implementerade för dessa i
högre klasser, som sedan kan overridas när avvikande beteende krävs. Detta skulle vara mer i linje med SoC att ha logiken för
Movable vid samma nivå.

-Automotive, VolvoWorkshop, Object2D
Img specificeras som en variabel som CarView använder vid rendering, och är definerad vid både automotive och volvoworkshop.
En rimlig förändring (DRY) är att helt enkelt låta varje Object2D ha en Img och CarView kan kalla på detta fält felfritt.



#### På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?
Ett exempel är VehicleWorkshop, som har flera subklasser som egentligen kan vara instanser av vehicleworkshop.
De har heller inte någon egen logik, utan specificerar bara fordonstypen.

Uppgift 4: Ny design

    Rita ett UML-diagram över en ny design som åtgärdar de brister ni identifierat med avseende både på beroenden och ansvarsfördelning.
    Motivera, i termer av de principer vi gått igenom, varför era förbättringar verkligen är förbättringar.
#### Skriv en refaktoriseringsplan. Den består av steg som tar nuvarande programmet till ett som implementerar er nya design.
Planen behöver inte vara enormt detaljerad. Se Övning 3 för ett exempel på en refaktoriseringsplan.

#### Finns det några delar av planen som går att utföra parallellt, av olika utvecklare somVilka beroenden är nödvändiga? arbetar oberoende av varandra?
#### Om inte, finns det något sätt att omformulera planen så att en sådan arbetsdelning är möjlig?

För att parallelt arbete skall vara möjligt krävs att någon av de följande gäller för varje ändring:
- Koden som arbetas på inte beror på annan kod som arbetas på.
- De som arbetar parallelt delar samma uppfattning kring gränssnittet mellan kodens beroenden. 

