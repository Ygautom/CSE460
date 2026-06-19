# SmartCity Hub — Phase I Implementation (CSE 460, Team 1)

A runnable Java implementation of the SmartCity Hub design from Phases I and II.
It realizes the three design patterns documented in the Phase II class diagram.

## How to build and run

From this folder:

```bash
javac -d out $(find src -name "*.java")
java -cp out smartcityhub.app.SmartCityHubApp
```

(On Windows PowerShell, compile with:
`javac -d out (Get-ChildItem -Recurse -Filter *.java src | % FullName)`)

Requires a JDK (Java 11 or later).

## What the demo shows

Running `SmartCityHubApp` exercises all three patterns end to end and prints the result:

1. **Singleton** — `NotificationManager.getInstance()` returns the same shared instance every time (the demo prints `true` to prove it).
2. **Factory Method** — `EventFactory.createEvent(type, ...)` builds the right `Event` subtype (SportsEvent, EnvironmentEvent, ...) without the caller hardcoding a class.
3. **Observer** — Citizens subscribe to the `NotificationManager`; when a `ServiceRequest` status changes, every subscribed citizen is notified. The demo also detaches one observer to show only the remaining citizen is notified afterward.

## Class → Phase II diagram mapping

| Class | Role in the diagram |
|-------|--------------------|
| `model/User` | Base class (userId, name, email, password) |
| `model/Citizen` | Inherits User, **implements Observer** |
| `model/Administrator` | Inherits User, uses EventFactory |
| `model/DepartmentManager` | Inherits User, updates request status |
| `model/Event` (abstract) | Base event (eventId, title, date, location, description) |
| `model/SportsEvent` etc. | Five concrete Event subtypes |
| `model/ServiceRequest` | Triggers notifications on status change |
| `model/Notification` | Notification entity |
| `model/RequestStatus` | Enumeration (OPEN, IN_PROGRESS, RESOLVED, CLOSED) |
| `patterns/Observer` | «interface» Observer |
| `patterns/EventFactory` | **Factory Method** pattern |
| `patterns/NotificationManager` | **Singleton** + Observer subject |
| `app/SmartCityHubApp` | Demonstration driver (main) |

## Source layout

```
src/smartcityhub/
  model/      domain classes from the class diagram
  patterns/   the three design patterns
  app/        SmartCityHubApp (main entry point)
```
