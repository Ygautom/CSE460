# Phase II — Changes and New Features

This document records what was added on top of the Phase I implementation. Each
addition maps to a use case from the Phase I submission, so every new piece can be
justified against the original requirements.

## Summary of what changed

| # | Addition | New / Modified | Phase I use case it satisfies |
|---|----------|----------------|-------------------------------|
| 1 | `AuthService` | New class | Login, Register Account |
| 2 | `ServiceRequestFactory` | New class | (second Factory named in Phase II design doc) |
| 3 | `ServiceRequestManager` | New class | Review Service Requests |
| 4 | Task assignment + reports | Modified `DepartmentManager` | Assign Tasks, Generate Reports |
| 5 | Typed requests | Modified `ServiceRequest`, `Citizen` | Update Request Status |
| 6 | Demo driver | Modified `SmartCityHubApp` | exercises all of the above |

## 1. Authentication — `AuthService` (new)

The Phase I document lists **Login** and **Register Account** as use cases, and
`User` already had a `login()` method, but nothing ever used it. `AuthService`
keeps a registry of users, registers accounts, and validates credentials through
the existing `User.login()`. The demo now shows one successful login and one
failed login (wrong password).

## 2. Second Factory — `ServiceRequestFactory` (new)

The Phase II design document explicitly names a `ServiceRequestFactory` next to
`EventFactory`. This new class implements it: `createRequest(type, ...)` builds a
request stamped with its issue type (POTHOLE, GRAFFITI, WATER_LEAK,
NOISE_COMPLAINT, BROKEN_STREETLIGHT). It mirrors `EventFactory` exactly, so the
two factories are consistent and both follow the Open/Closed Principle.

## 3. Request tracking — `ServiceRequestManager` (new)

Parallels the existing `EventManager`, but for service requests. It stores every
submitted request and supports lookup by id, filtering by status, a full listing,
and per-status counts. This is what the Administrator's **Review Service
Requests** use case needs — previously requests were created but never tracked in
a collection.

## 4. Assignment and reporting — `DepartmentManager` (modified)

Two methods were added to satisfy Phase I use cases that were not yet coded:
- `assignTask(request)` — **Assign Tasks**: the manager takes ownership of a
  request, recorded via the new `assignTo` field on `ServiceRequest`.
- `generateRequestReport(requestManager)` — **Generate Reports**: prints totals
  and a per-status breakdown (Open / In Progress / Resolved / Closed). The
  original `generateReport(eventManager)` was kept.

## 5. Typed requests — `ServiceRequest` and `Citizen` (modified)

`ServiceRequest` gained an `issueType` field and an `assignedTo` field, plus a
typed constructor used by the factory. The original no-type constructor still
works (it defaults the type to GENERAL), so nothing that already called it broke.
`Citizen` gained `submitTypedRequest(type, ...)` which goes through the factory,
alongside the original `submitRequest(...)`.

## 6. Demo driver — `SmartCityHubApp` (modified)

The `main` method now also: registers and logs in users, stores requests in the
`ServiceRequestManager`, builds requests through the factory, assigns a task,
reviews/filters requests, and prints both reports. All of the original Phase I
demonstration (Singleton check, event factory, event search, registration,
participant listing, observer notify/detach) was kept intact.

## Design patterns now in the code

- **Factory Method** — `EventFactory` (events) **and** `ServiceRequestFactory` (requests)
- **Observer** — `Citizen implements Observer`, notified by `NotificationManager` on status change
- **Singleton** — `NotificationManager` (one shared instance)

## What was NOT changed

The three Phase I design patterns and their class structure are untouched in
behavior — they were extended, not rewritten. All additions are backward
compatible: every original constructor and method still exists and still works.

## How to build and run

```bash
javac -d out $(find src -name "*.java")
java -cp out smartcityhub.app.SmartCityHubApp
```
