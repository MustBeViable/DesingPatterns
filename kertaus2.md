# Design Pattern -kertaus

Tämä kertaus on koottu liitteissä olleista aiheista samaan tyyliin kuin antamasi `kertaus.md`: lyhyt idea, käyttötarkoitus, rakenne, edut, haitat, avaintermit ja pieni Java-esimerkki.

---

## Memento

**Ryhmä:** Behavioral

**Idea:**  
Memento tallentaa olion tilan erilliseen memento-olioon, jotta tila voidaan palauttaa myöhemmin esimerkiksi undo-toimintoa varten.

**Käyttötarkoitus:**  
Käytetään, kun halutaan toteuttaa undo turvallisesti ilman, että olion sisäinen tila paljastetaan muille luokille.

**Yleinen rakenne ja roolit:**
- `Originator` = luo mementon omasta tilastaan ja palauttaa tilansa mementosta
- `Memento` = säilyttää snapshotin tilasta
- `Caretaker` = hallitsee mementojen historiaa, mutta ei muuta niiden sisältöä

**Edut:**
- Undo on helppo toteuttaa
- Säilyttää kapseloinnin paremmin kuin käsin kirjoitetut peruutusmetodit
- Historiatilan hallinta voidaan keskittää caretakerille

**Haitat / huomioitavaa:**
- Mementot voivat kuluttaa paljon muistia
- Deep vs shallow copy voi aiheuttaa ongelmia
- Inkrementaalinen tallennus säästää muistia mutta monimutkaistaa toteutusta

**Avaintermit:**  
`Originator`, `Memento`, `Caretaker`, snapshot, undo, metadata interface, deep copy, shallow copy

**Java-esimerkki:**
```java
class EditorMemento {
    private final String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Editor {
    private String text = "";

    public void setText(String text) {
        this.text = text;
    }

    public EditorMemento createMemento() {
        return new EditorMemento(text);
    }

    public void setMemento(EditorMemento memento) {
        this.text = memento.getText();
    }

    public String getText() {
        return text;
    }
}
```

---

## Proxy

**Ryhmä:** Structural

**Idea:**  
Proxy tarjoaa korvaavan olion toiselle oliolle ja kontrolloi pääsyä siihen. Proxy ja oikea olio toteuttavat saman rajapinnan.

**Käyttötarkoitus:**  
Käytetään, kun halutaan rajoittaa pääsyä olioon, viivästää sen luontia, lisätä suojausta, lokitusta tai muuta välissä tehtävää hallintaa.

**Yleinen rakenne ja roolit:**
- `Subject` = yhteinen rajapinta clientille
- `RealSubject` = oikea olio, joka tekee työn
- `Proxy` = hallitsee pääsyä `RealSubject`-olioon
- `Client` = käyttää `Subject`-rajapintaa

**Edut:**
- Mahdollistaa lazy loadingin
- Voi lisätä access controlin tai loggingin
- Client voi käyttää proxya kuin oikeaa oliota

**Haitat / huomioitavaa:**
- Lisää epäsuoraa rakennetta ja monimutkaisuutta
- Lazy loading voi aiheuttaa viiveen yllättävässä kohdassa
- Proxyn tilan hallinta voi olla vaikeaa etenkin rinnakkaisuudessa

**Tyyppejä:**
- `Remote Proxy`
- `Virtual Proxy`
- `Protection Proxy`

**Avaintermit:**  
`Subject`, `Proxy`, `RealSubject`, lazy loading, virtual proxy, protection proxy, remote proxy

**Java-esimerkki:**
```java
interface Image {
    void display();
}

class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ImageProxy implements Image {
    private final String fileName;
    private RealImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

---

## Visitor

**Ryhmä:** Behavioral

**Idea:**  
Visitor erottaa algoritmit oliorakenteesta, jotta uusia toimintoja voidaan lisätä muuttamatta itse elementtiluokkia.

**Käyttötarkoitus:**  
Hyödyllinen, kun käytössä on vakaa elementtihierarkia mutta sille pitää lisätä usein uusia operaatioita, kuten renderöinti, laskenta tai vienti.

**Yleinen rakenne ja roolit:**
- `Visitor` = määrittää `visitX()`-metodit eri elementeille
- `ConcreteVisitor` = toteuttaa algoritmin
- `Element` = määrittää `accept(visitor)`
- `ConcreteElement` = kutsuu visitorin oikeaa metodia
- `ObjectStructure` = kokoelma elementtejä

**Edut:**
- Uusien toimintojen lisääminen on helppoa
- Algoritmit saadaan pois elementtiluokista
- Visitor voi kerätä tilaa traversal aikana

**Haitat / huomioitavaa:**
- Uuden elementtiluokan lisääminen on työlästä
- Saattaa rikkoa kapselointia getterien kautta
- Vaatii paljon `visit`-metodeja suurissa hierarkioissa

**Avaintermit:**  
`Visitor`, `ConcreteVisitor`, `Element`, `accept`, double dispatch, object structure

**Java-esimerkki:**
```java
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

interface Shape {
    void accept(ShapeVisitor visitor);
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
```

---

## Builder

**Ryhmä:** Creational

**Idea:**  
Builder rakentaa monimutkaisen olion vaihe vaiheelta ja erottaa rakentamisen itse tuotteen esitystavasta.

**Käyttötarkoitus:**  
Käytetään, kun olion rakentaminen on monivaiheista tai sama rakennusprosessi voi tuottaa eri lopputuloksia.

**Yleinen rakenne ja roolit:**
- `Builder` = määrittää rakennusvaiheet
- `ConcreteBuilder` = toteuttaa vaiheet ja kokoaa tuotteen
- `Director` = ohjaa rakentamisen järjestystä
- `Product` = valmis rakennettu olio

**Edut:**
- Poistaa telescoping constructor -ongelman
- Rakentaminen ja esitystapa erotetaan toisistaan
- Sama prosessi voi tuottaa eri tuotteita

**Haitat / huomioitavaa:**
- Voi olla turhan raskas yksinkertaisille olioille
- Luokkien määrä kasvaa
- Client-koodi voi muuttua vähemmän selkeäksi pitkien builder-ketjujen vuoksi

**Avaintermit:**  
`Builder`, `ConcreteBuilder`, `Director`, `Product`, step-by-step construction, `getResult()`

**Java-esimerkki:**
```java
class Burger {
    private String bun;
    private String patty;
    private String sauce;

    public void setBun(String bun) { this.bun = bun; }
    public void setPatty(String patty) { this.patty = patty; }
    public void setSauce(String sauce) { this.sauce = sauce; }

    @Override
    public String toString() {
        return bun + ", " + patty + ", " + sauce;
    }
}

interface BurgerBuilder {
    void buildBun();
    void buildPatty();
    void buildSauce();
    Burger getResult();
}

class CheeseBurgerBuilder implements BurgerBuilder {
    private final Burger burger = new Burger();

    public void buildBun() { burger.setBun("Sesame bun"); }
    public void buildPatty() { burger.setPatty("Beef patty"); }
    public void buildSauce() { burger.setSauce("Cheese sauce"); }
    public Burger getResult() { return burger; }
}
```

---

## Adapter

**Ryhmä:** Structural

**Idea:**  
Adapter muuntaa yhden rajapinnan toisenlaiseksi, jotta yhteensopimattomat luokat voivat toimia yhdessä.

**Käyttötarkoitus:**  
Käytetään, kun halutaan käyttää olemassa olevaa luokkaa, mutta sen rajapinta ei sovi clientin odottamaan muotoon.

**Yleinen rakenne ja roolit:**
- `Target` = rajapinta, jota client käyttää
- `Client` = käyttää `Target`-rajapintaa
- `Adaptee` = olemassa oleva yhteensopimaton luokka
- `Adapter` = kääntää `Adaptee`-kutsut `Target`-muotoon

**Toteutustavat:**
- `Object Adapter` = sisältää viitteen adaptee-olioon
- `Class Adapter` = perii / implementoi useita rajapintoja mahdollisuuksien mukaan

**Edut:**
- Mahdollistaa vanhan koodin uudelleenkäytön
- Parantaa yhteensopivuutta
- Irrottaa clientin adapteen yksityiskohdista

**Haitat / huomioitavaa:**
- Lisää yhden ylimääräisen kerroksen
- Adapteri voi kasvaa monimutkaiseksi
- Kaikki adapteen ominaisuudet eivät aina istu siististi targetiin

**Avaintermit:**  
`Target`, `Adapter`, `Adaptee`, object adapter, class adapter, interface translation

**Java-esimerkki:**
```java
interface Shape {
    void draw();
}

class TextView {
    public void specificRender() {
        System.out.println("Rendering text");
    }
}

class TextShapeAdapter implements Shape {
    private final TextView textView;

    public TextShapeAdapter(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void draw() {
        textView.specificRender();
    }
}
```

---

## Prototype

**Ryhmä:** Creational

**Idea:**  
Prototype luo uusia olioita kopioimalla olemassa olevia prototyyppejä sen sijaan, että ne rakennettaisiin aina alusta.

**Käyttötarkoitus:**  
Sopii tilanteisiin, joissa olion luonti on kallista tai clientin ei pitäisi tietää, minkä konkreettisen luokan olioita se luo.

**Yleinen rakenne ja roolit:**
- `Prototype` = määrittää `clone()`-rajapinnan
- `ConcretePrototype` = toteuttaa kloonauksen
- `Client` = pyytää prototyyppiä kloonaamaan itsensä

**Edut:**
- Voi olla nopeampi kuin uuden olion rakentaminen
- Client ei ole sidottu konkreettisiin luokkiin
- Sopii framework-tyyppisiin tilanteisiin, joissa luotavat tyypit vaihtelevat

**Haitat / huomioitavaa:**
- Deep vs shallow copy voi aiheuttaa virheitä
- Suurten olioiden kloonaus voi olla kallista
- Mutable-kentät voivat aiheuttaa sivuvaikutuksia shallow copyssa
- Sykliset viitteet vaikeuttavat toteutusta

**Avaintermit:**  
`Prototype`, `ConcretePrototype`, `clone()`, deep copy, shallow copy, `Cloneable`

**Java-esimerkki:**
```java
class Note implements Cloneable {
    private String pitch;

    public Note(String pitch) {
        this.pitch = pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    @Override
    public Note clone() {
        try {
            return (Note) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

---

## Mediator

**Ryhmä:** Behavioral

**Idea:**  
Mediator keskittää useiden olioiden välisen kommunikoinnin yhteen paikkaan ja vähentää suoria riippuvuuksia niiden välillä.

**Käyttötarkoitus:**  
Käytetään, kun järjestelmässä on paljon oliota, jotka muuten viittaisivat toisiinsa sekavasti.

**Yleinen rakenne ja roolit:**
- `Mediator` = määrittää kommunikointirajapinnan
- `ConcreteMediator` = toteuttaa kommunikoinnin logiikan
- `Colleague` = osallistuja, joka kommunikoi mediatorin kautta
- `ConcreteColleague` = konkreettinen osallistuja

**Edut:**
- Vähentää tight couplingia kollegoiden välillä
- Keskittää kommunikointilogiikan
- Helpottaa muutosten tekemistä ja uusien osallistujien lisäämistä

**Haitat / huomioitavaa:**
- Mediatorista voi tulla pullonkaula
- Voi muuttua single point of failureksi
- Liian suuri mediator voi muistuttaa god objectia

**Avaintermit:**  
`Mediator`, `ConcreteMediator`, `Colleague`, centralized communication, DialogDirector

**Java-esimerkki:**
```java
interface ChatMediator {
    void sendMessage(String message, User sender);
}

class SimpleChatMediator implements ChatMediator {
    private final java.util.List<User> users = new java.util.ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

class User {
    private final String name;
    private final ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.sendMessage(name + ": " + message, this);
    }

    public void receive(String message) {
        System.out.println(message);
    }
}
```

---

## Iterator

**Ryhmä:** Behavioral

**Idea:**  
Iterator tarjoaa yhtenäisen tavan käydä kokoelman elementtejä läpi paljastamatta kokoelman sisäistä rakennetta.

**Käyttötarkoitus:**  
Käytetään, kun kokoelman läpikäynti halutaan erottaa sen business logicista ja piilottaa traversal-toteutus clientilta.

**Yleinen rakenne ja roolit:**
- `Aggregate` = osaa luoda iteratorin
- `ConcreteAggregate` = konkreettinen kokoelma
- `Iterator` = traversal-rajapinta
- `ConcreteIterator` = toteuttaa iteroinnin tilan ja logiikan
- `Client` = pyytää iteratorin ja käyttää sitä läpikäyntiin

**Edut:**
- Erottaa traversal-logiikan kokoelmasta
- Mahdollistaa useita erilaisia iterointitapoja
- Vähentää indeksi- ja rajavirheitä client-koodissa

**Haitat / huomioitavaa:**
- Kokoelman muokkaaminen iteroinnin aikana voi sekoittaa traversal-tilan
- Lisää luokkia verrattuna yksinkertaiseen suoraan läpikäyntiin

**Avaintermit:**  
`Aggregate`, `ConcreteAggregate`, `Iterator`, `ConcreteIterator`, `hasNext()`, `next()`

**Java-esimerkki:**
```java
java.util.List<String> names = java.util.Arrays.asList("A", "B", "C");
java.util.Iterator<String> it = names.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## Facade

**Ryhmä:** Structural

**Idea:**  
Facade tarjoaa yksinkertaisen korkeamman tason rajapinnan monimutkaiseen alijärjestelmään.

**Käyttötarkoitus:**  
Käytetään, kun clientin ei haluta käsittelevän subsystemin monia luokkia, vaiheita ja riippuvuuksia suoraan.

**Yleinen rakenne ja roolit:**
- `Facade` = yhdistetty helppokäyttöinen rajapinta
- `Subsystem Classes` = tekevät varsinaisen työn
- `Client` = käyttää facadea tai tarvittaessa subsystemiä suoraan

**Edut:**
- Yksinkertaistaa clientin käyttöä
- Vähentää clientin ja subsystemin välistä couplingia
- Parantaa ylläpidettävyyttä keskittämällä orkestroinnin

**Haitat / huomioitavaa:**
- Facadesta voi tulla single point of failure
- Saattaa aiheuttaa pientä overheadia
- Testaus voi olla hankalaa, koska facade riippuu monista alijärjestelmistä
- Liian laaja facade voi muuttua god objectiksi

**Avaintermit:**  
`Facade`, subsystem, higher-level interface, simplified access, centralized control point

**Java-esimerkki:**
```java
class Scanner {
    public void scan() { System.out.println("Scanning source"); }
}

class Parser {
    public void parse() { System.out.println("Parsing tokens"); }
}

class CodeGenerator {
    public void generate() { System.out.println("Generating code"); }
}

class CompilerFacade {
    private final Scanner scanner = new Scanner();
    private final Parser parser = new Parser();
    private final CodeGenerator generator = new CodeGenerator();

    public void compile() {
        scanner.scan();
        parser.parse();
        generator.generate();
    }
}
```

---

## Command

**Ryhmä:** Behavioral

**Idea:**  
Command kapseloi pyynnön olioksi. Näin pyyntöjä voidaan välittää, tallentaa, jonottaa ja suorittaa myöhemmin yhtenäisen `execute()`-rajapinnan kautta.

**Käyttötarkoitus:**  
Käytetään, kun halutaan erottaa pyynnön lähettäjä sen toteuttajasta tai tukea undoa, makrokomentoja, jonotusta tai ajastusta.

**Yleinen rakenne ja roolit:**
- `Command` = yhteinen rajapinta, esim. `execute()`
- `ConcreteCommand` = toteuttaa pyynnön ja tuntee receiverin
- `Receiver` = tekee varsinaisen työn
- `Invoker` = kutsuu komentoa
- `Client` = luo komennon, asettaa receiverin ja liittää sen invokeriin

**Edut:**
- Irrottaa lähettäjän toteutuksesta
- Tukee helppoa laajennettavuutta
- Mahdollistaa komentojen jonotuksen, logituksen ja makrokomennot

**Haitat / huomioitavaa:**
- Lisää luokkien määrää
- Dynaaminen komentojen luonti voi monimutkaistaa client-koodia
- Receiverin hard-code komennon sisään vähentää joustavuutta

**Avaintermit:**  
`Command`, `ConcreteCommand`, `Invoker`, `Receiver`, `execute()`, macro command, queue

**Java-esimerkki:**
```java
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light on");
    }
}

class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

---

## Nopea muistilista eroista

- **Adapter** = tekee yhteensopimattomista rajapinnoista yhteensopivia
- **Facade** = yksinkertaistaa monimutkaisen subsystemin käyttöä
- **Proxy** = kontrolloi pääsyä oikeaan olioon
- **Builder** = rakentaa monimutkaisen olion vaiheittain
- **Prototype** = luo uuden olion kopioimalla olemassa olevan
- **Iterator** = kulkee kokoelman läpi piilottaen sisäisen rakenteen
- **Mediator** = keskittää olioiden välisen kommunikoinnin
- **Command** = kapseloi pyynnön olioksi
- **Memento** = tallentaa olion tilan undoa varten
- **Visitor** = lisää uusia operaatioita muuttamatta elementtiluokkia
