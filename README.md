
# 📞 IVR Project – Automated Calling System

An intelligent **Interactive Voice Response (IVR)** system built using **Kotlin + Jetpack Compose**, designed to automate outbound calls, record user responses, and sync data to a backend server. This project was built for organizations like hospitals or educational institutions to streamline daily check-ins, reminders, or surveys.

---

## 🧩 Key Features

- ⏰ **Scheduled Calls** from 9 AM to 5 PM (automated daily)
- 📡 **Bluetooth Integration** to receive call responses from an external device
- 📥 **Toggle Switch** to enable/disable the daily call flow
- 💾 **Local Database** support for offline logging
- 🔄 **Backend Syncing** of call logs using REST APIs
- 🔐 Permission-handling for phone calls and background services

---

## 🛠️ Tech Stack

| Layer      | Technology          |
|------------|---------------------|
| Frontend   | Kotlin + Jetpack Compose |
| Background Tasks | WorkManager, AlarmManager |
| Backend    | ExpressJS + MySQL (XAMPP) |
| Storage    | Room Database or SharedPreferences |
| API Client | Retrofit |

---



---

## 🔄 Daily Flow

1. At **9 AM**, fetch data (list of users/numbers) from backend API  
2. Begin automated calls to each number sequentially  
3. Log response received (via **Bluetooth** or **manual UI tap**)  
4. Store the response locally and sync it back to the backend  
5. End process automatically at **5 PM**  

---

## 🔧 Environment Setup

### Backend API (.env / XAMPP config)

Make sure to configure your backend API for:
- `/api/get-call-schedule` (GET)
- `/api/update-response` (POST)

Update API endpoints in `Retrofit` service interface in your app.

### Permissions Required

- `CALL_PHONE`
- `FOREGROUND_SERVICE`
- `BLUETOOTH_CONNECT` (for Android 12+)
- `RECEIVE_BOOT_COMPLETED` (optional for auto-scheduling)

---

## ⚙️ How to Run

1. Clone the repository
2. Connect HC-05 Bluetooth module to your testing device
3. Add phone numbers and schedules to backend DB
4. Run the app and enable the **daily call toggle**

---

## 📦 Future Improvements

- 🔄 Auto-retry failed calls
- 📈 Admin dashboard for call logs and metrics
- 📲 Android app notifications for pending tasks
- 🌐 Switch to cloud backend (Firebase, Render, etc.)

---

## 🧑‍💻 Developed By

**Mayank Jonwal**  
B.Tech AI & Data Science, IIT Jodhpur  

[LinkedIn](https://www.linkedin.com/in/mayankjonwal) • [GitHub](https://github.com/<your-username>)

---

## 📄 License

This project is built for academic and institutional use. Contact for collaboration or deployment permissions.
