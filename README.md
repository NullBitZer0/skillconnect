# SkillConnect

A skill sharing and connection Android app that allows users to discover and connect with people offering various skills in their area.

## Features

- Browse nearby skill requests
- Post new skill requests
- Modern Material Design UI
- Bottom navigation with Home and Profile sections
- Onboarding flow for new users

## Prerequisites

Before running this project, make sure you have the following installed:

- [Android Studio](https://developer.android.com/studio) (latest version recommended)
- Android SDK (API level 21 or higher)
- Java Development Kit (JDK) 8 or higher
- Git

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/NullBitZer0/skillconnect.git
cd skillconnect
```

### 2. Open in Android Studio

1. Launch Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to the cloned `skillconnect` folder and select it
4. Wait for Android Studio to sync the project

### 3. Set Up Android Device/Emulator

#### Option A: Physical Device
1. Enable Developer Options on your Android device
2. Turn on USB Debugging
3. Connect your device via USB
4. Allow USB debugging when prompted

#### Option B: Android Emulator
1. In Android Studio, go to Tools → AVD Manager
2. Create a new Virtual Device (recommended: Pixel with API 21+)
3. Start the emulator

### 4. Build and Run

1. Make sure your device/emulator is connected and recognized
2. Click the "Run" button (green play icon) in Android Studio
3. Select your target device
4. The app will build and install automatically

## Project Structure

```
app/
├── src/main/java/com/example/skillconnect/
│   ├── MainActivity.kt                    # Main activity with navigation
│   ├── NewSkillRequestDialogFragment.kt   # Dialog for posting new requests
│   ├── adapters/
│   │   └── NearbyRequestsAdapter.kt       # RecyclerView adapter
│   ├── fragments/
│   │   └── HomeFragment.kt                # Home screen with nearby requests
│   └── models/
│       └── NearbyRequest.kt               # Data model for requests
└── src/main/res/
    ├── layout/                            # XML layout files
    ├── drawable/                          # Icons and graphics
    ├── values/                            # Colors, strings, styles
    └── menu/                              # Navigation menu
```

## Troubleshooting

### Build Issues
- Make sure you're using the correct Android SDK version
- Clean and rebuild the project (Build → Clean Project → Rebuild Project)
- Sync project with Gradle files (File → Sync Project with Gradle Files)

### Emulator Issues
- Ensure virtualization is enabled in your BIOS
- Try creating a new AVD with different API levels
- Increase RAM allocation for the emulator

### Device Connection Issues
- Check USB debugging is enabled
- Try different USB cables/ports
- Install appropriate device drivers

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).