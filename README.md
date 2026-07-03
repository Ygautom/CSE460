# SmartCity Hub - Full Rubric Version

This version is cleaned up for the Project Functionality rubric. It is compile-ready and removes the duplicate `EventFactory` problem.

## Build and run

From this folder:

```bash
javac -d out $(find src -name "*.java")
java -cp out smartcityhub.app.SmartCityHubApp
```

Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | % FullName)
java -cp out smartcityhub.app.SmartCityHubApp
```

## Rubric coverage

| Rubric item | Where it is implemented |
|---|---|
| Event Discovery | `EventManager` supports browsing upcoming events sorted by category and searching/filtering by category, date, location, free/paid, and popularity. |
| Event categories | `EventCategory` includes Music, Tech, Sports, Social, Career, Education, Environment, Cultural, and Community Service. |
| Service Request Management | `Citizen.submitRequest`, `Citizen.submitTypedRequest`, `ServiceRequest`, `ServiceRequestFactory`, and `ServiceRequestManager`. |
| Users track service request progress | `Citizen.viewMyRequests()` shows a resident only their submitted request statuses. |
| City departments update progress | `DepartmentManager.assignTask()` and `DepartmentManager.updateRequestStatus()` update request assignment and status. |
| Admin Dashboard | `Administrator.showAdminDashboard()` displays total events, total requests, request counts by status, event list, and all service requests. |
| Overall completeness/UI | `SmartCityHubApp` prints clear section headers so the demo is easy to follow. |
| Video demo | Run `SmartCityHubApp` and record the full terminal output. |

## Suggested video demo order

1. Show the project compiling successfully.
2. Run `SmartCityHubApp`.
3. Show authentication/login.
4. Show event discovery sorted by category.
5. Show filters: category, location, free/paid, popularity, date, and combined filters.
6. Show citizens registering for events.
7. Show citizens submitting service requests.
8. Show residents tracking their request status.
9. Show the department manager assigning and updating requests.
10. Show notifications sent to residents.
11. Show the department report and admin dashboard.
