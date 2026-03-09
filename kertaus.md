# Design patternit – pidempi kooste

## Singleton

**Ryhmä:** Creational

**Idea:** Varmistaa, että luokasta on vain yksi instanssi ja tarjoaa keskitetyn pääsyn siihen.

**Edut:**
- Yksi yhteinen instanssi
- Sopii yhteiseen resurssiin kuten loggeriin tai asetuksiin

**Haitat:**
- Globaali tila vaikeuttaa testausta
- Lazy-toteutus vaatii säieturvallisuutta

**Avaintermit:** private constructor, static instance, getInstance(), eager / lazy / enum

**Java-esimerkki:**
```java
enum Logger {
    INSTANCE;

    public void log(String msg) {
        System.out.println(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger.INSTANCE.log("Hello");
    }
}
```

## Factory Method

**Ryhmä:** Creational

**Idea:** Määrittää rajapinnan olion luomiselle, mutta aliluokka päättää mikä konkreettinen tuote luodaan.

**Edut:**
- Poistaa olioluontia clientilta
- Vähentää tight couplingia
- Uusia tuotteita voi lisätä helposti

**Haitat:**
- Luokkien määrä kasvaa
- Voi tulla boilerplatea

**Avaintermit:** Creator, ConcreteCreator, Product, ConcreteProduct

**Java-esimerkki:**
```java
interface Product { void use(); }
class Car implements Product {
    public void use() { System.out.println("Car"); }
}

abstract class Creator {
    public abstract Product createProduct();
}

class CarCreator extends Creator {
    public Product createProduct() { return new Car(); }
}
```

## Abstract Factory

**Ryhmä:** Creational

**Idea:** Luo toisiinsa liittyvien tuotteiden perheitä ilman että client tuntee konkreettisia luokkia.

**Edut:**
- Tuoteperheen yhteensopivuus
- Client irtoaa konkreettisista luokista

**Haitat:**
- Uuden tuotetyypin lisääminen koskee kaikkia tehtaita
- Paljon luokkia

**Avaintermit:** AbstractFactory, ConcreteFactory, AbstractProduct, ConcreteProduct

**Java-esimerkki:**
```java
interface Button { void draw(); }
interface Checkbox { void draw(); }

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

## Composite

**Ryhmä:** Structural

**Idea:** Käsittelee yksittäisiä olioita ja olioryhmiä samalla tavalla puumaisessa osa–kokonaisuus-rakenteessa.

**Edut:**
- Client voi kutsua koko puuta yhdestä kohdasta
- Rekursiivinen käsittely on luontevaa

**Haitat:**
- Yhteisen rajapinnan suunnittelu voi olla hankalaa
- Transparency-mallissa leafille voi tulla turhia metodeja

**Avaintermit:** Component, Leaf, Composite; transparency vs safety

**Java-esimerkki:**
```java
interface Component { int getValue(); }

class Leaf implements Component {
    public int getValue() { return 5; }
}

class Composite implements Component {
    private java.util.List<Component> children = new java.util.ArrayList<>();
    public void add(Component c) { children.add(c); }
    public int getValue() {
        int sum = 0;
        for (Component c : children) sum += c.getValue();
        return sum;
    }
}
```

## Decorator

**Ryhmä:** Structural

**Idea:** Lisää oliolle uutta toimintaa ajonaikaisesti käärimällä se toisen olion sisään.

**Edut:**
- Välttää suuren aliluokkahierarkian
- Ominaisuuksia voi ketjuttaa joustavasti

**Haitat:**
- Ketjut voivat vaikeuttaa debuggausta
- Decoratorien järjestyksellä voi olla väliä

**Avaintermit:** Component, ConcreteComponent, Decorator, ConcreteDecorator

**Java-esimerkki:**
```java
interface Text { String render(); }

class PlainText implements Text {
    public String render() { return "hello"; }
}

abstract class TextDecorator implements Text {
    protected final Text inner;
    TextDecorator(Text inner) { this.inner = inner; }
}

class XmlDecorator extends TextDecorator {
    XmlDecorator(Text inner) { super(inner); }
    public String render() { return "<xml>" + inner.render() + "</xml>"; }
}
```

## Observer

**Ryhmä:** Behavioral

**Idea:** Subject ilmoittaa automaattisesti observereille, kun sen tila muuttuu.

**Edut:**
- Löyhä kytkentä
- Sama muutos voidaan välittää monelle kuuntelijalle

**Haitat:**
- Ketjureaktiot vaikeuttavat debuggausta
- Ilmoitusjärjestyksellä voi olla väliä

**Avaintermit:** Subject, Observer, ConcreteSubject, ConcreteObserver; push vs pull

**Java-esimerkki:**
```java
interface Observer { void update(int value); }

class Subject {
    private java.util.List<Observer> observers = new java.util.ArrayList<>();
    void add(Observer o) { observers.add(o); }
    void setValue(int v) {
        for (Observer o : observers) o.update(v);
    }
}
```

## State

**Ryhmä:** Behavioral

**Idea:** Olion käyttäytyminen muuttuu sen nykyisen tilan mukaan ilman suurta if–else-rakennetta.

**Edut:**
- Tilakohtainen logiikka eriytyy omiin luokkiin
- Uusia tiloja voi lisätä selkeästi

**Haitat:**
- Luokkien määrä kasvaa
- Pienessä ongelmassa voi olla overkill

**Avaintermit:** Context, State, ConcreteState

**Java-esimerkki:**
```java
interface State { void press(Context c); }

class Context {
    private State state;
    Context(State s) { this.state = s; }
    void setState(State s) { this.state = s; }
    void press() { state.press(this); }
}
```

## Template Method

**Ryhmä:** Behavioral

**Idea:** Kantaluokka määrittää algoritmin rungon, mutta jättää osan vaiheista aliluokkien toteutettaviksi.

**Edut:**
- Vähentää toistoa
- Yhtenäinen suoritusjärjestys

**Haitat:**
- Jäykkä runko
- Vaikea suunnitella tarpeeksi yleiseksi

**Avaintermit:** template method, abstract steps, default methods, hooks

**Java-esimerkki:**
```java
abstract class Beverage {
    public final void prepare() {
        boilWater();
        brew();
        pour();
    }
    void boilWater() { System.out.println("Boil"); }
    abstract void brew();
    void pour() { System.out.println("Pour"); }
}
```

## Strategy

**Ryhmä:** Behavioral

**Idea:** Kapseloi eri algoritmit omiin luokkiinsa ja tekee niistä vaihdettavia.

**Edut:**
- Strategia voidaan vaihtaa ajonaikaisesti
- Vähentää if–else-valintoja

**Haitat:**
- Clientin pitää tuntea vaihtoehdot
- Yksinkertaisessa tilanteessa raskas

**Avaintermit:** Strategy, ConcreteStrategy, Context

**Java-esimerkki:**
```java
interface SortStrategy { void sort(int[] a); }

class BubbleSort implements SortStrategy {
    public void sort(int[] a) { /* ... */ }
}

class Context {
    private SortStrategy strategy;
    Context(SortStrategy strategy) { this.strategy = strategy; }
    void execute(int[] a) { strategy.sort(a); }
}
```

## Chain of Responsibility

**Ryhmä:** Behavioral

**Idea:** Pyyntö kulkee käsittelijöiden ketjussa, kunnes joku käsittelee sen tai ketju loppuu.

**Edut:**
- Lähettäjä ei tiedä lopullista käsittelijää
- Käsittelijöitä voi järjestää uudelleen

**Haitat:**
- Pyyntö voi jäädä käsittelemättä
- Ketjun toimintaa voi olla vaikea seurata

**Avaintermit:** Handler, ConcreteHandler, next

**Java-esimerkki:**
```java
abstract class Handler {
    protected Handler next;
    void setNext(Handler next) { this.next = next; }
    void handle(String req) {
        if (next != null) next.handle(req);
    }
}
```
