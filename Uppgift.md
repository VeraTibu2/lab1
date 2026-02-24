## Uppgift 1: Koppla på grafiskt gränssnitt

Börja med att forka och klona repot https://github.com/oopd-gu-chalmers/lab2.

Där hittar ni bland annat några nya klassfiler. Notera att de nya klasserna har många allvarliga brister vad gäller både design och implementation.

Visualizer.CarController, Visualizer.CarView och Visualizer.DrawPanel utgör tillsammans ett grafiskt användargränssnitt till era fordonsklasser från laboration 1.
Gränssnittet är skrivet av en tredje part som inte haft tillgång till vare sig kod, dokumentation eller designdokument för er lösning.

- [ ] Gör de eventuella (minimala) ändringar i Visualizer.CarController,

- [ ] Visualizer.CarView och Visualizer.DrawPanel som behövs för att det ska gå att använda tillsammans med er lösning från laboration 1.

- [ ] Kör Visualizer.CarController och se Volvo-bilen röra sig (genom att öka värdet på gasen och gasa).

- Se till att även bromsknappen är kopplad till bilen, så att den får effekt på er simulation (bromsvärdet får ni från samma snurra som gasen hämtar sitt värde ifrån).
  - Ni måste se till att modellens tillstånd uppdateras, och sen anropar tillbaka till Visualizer.CarView via Visualizer.CarController.

- [ ] Se till att när bilen nuddar en vägg så stoppar den helt, inverterar sin riktning och startar igen.
  Sätt in VehiclesModule.CarsHandler.CarTypes.Saab95, VehiclesModule.TrucksHandler.Trucktypes.Scania
  och deras respektive bilder med 100 pixlars avstånd i Y-led från varandra (alla avbildas ursprungligen med X=0).
- [ ] Koppla turbo-knapparna till Saaben och flakknapparna till VehiclesModule.TrucksHandler.Trucktypes.Scania.
- [ ] Koppla "starta och stoppa alla bilar"-knapparna till bägge. Även dessa bilar ska förhindras att åka utanför rutan.
- [ ] Skapa en workshop för Volvo-bilar, och koppla denna till utritningen.
  Se till att när en Volvo-bil åker till (dvs "krockar med") verkstaden "lastas" den i verkstaden.
  Andra bilar ska inte lastas (välj själva hur ni vill hantera detta).


## Uppgift 2: Beroenden

    Rita upp ett UML-diagram över systemet i dess nuvarande skick, efter era förändringar ovan. 
    Inkludera samtliga klasser, och samtliga interna beroenden mellan klasserna i UML-diagrammet. 
    Skilj på association, usage dependency, generalisering och realisering. 
    Ni behöver inte ha med alla metoder och fält, men inkludera det som behövs för att åskådliggöra designen;
    varför de beroenden som finns finns, och vilka ansvarsområden olika delar har. 
    Ni får rita UML-diagrammet med vilket verktyg ni vill så länge resultatet är läsbart.
    Analysera de beroenden som finns med avseende på cohesion och coupling, och Dependency Inversion Principle.
- [ ] Vilka beroenden är nödvändiga? Vilka klasser är beroende av varandra som inte borde vara det?
  - Finns det starkare beroenden än nödvändigt?

- [ ] Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?

## Uppgift 3: Ansvarsområden

#### Analysera era klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP).

#### Vilka ansvarsområden har era klasser?
#### Vilka anledningar har de att förändras?

- Object2D: Beskriver generiska egenskaper för objekt i planet, alltså position i x och y.
- Vehicle: För allting som skall färdas i våran modell. Innehåller våran representation av ett fordons riktning.

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

