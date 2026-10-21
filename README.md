# BitFit

A small Android app for logging how much you slept and how you felt each morning. I built it for CodePath's Android course.

## What it does

The app is one screen:

- A sleep slider from 0 to 24 hours in half-hour steps, and a feeling slider from 0 to 10.
- An optional notes field and an optional photo picked from the device.
- A Save button that stores the entry with today's date.
- A summary card with your average hours of sleep and average feeling across all entries.
- A list of past entries, newest first, showing the date, notes, hours slept, feeling, and the photo if there is one.

Entries are saved in a local Room (SQLite) database, so they stay after the app is closed. The list and the averages update on their own whenever a new entry is saved.

## Tech stack

Kotlin, Android SDK (min SDK 24), Room with Kotlin coroutines and Flow, RecyclerView, Material sliders, Glide for photos.

## How to run it

1. Clone the repo and open it in Android Studio.
2. Let Gradle sync, then run the `app` configuration on an emulator or a device.

No API keys are needed.

## Status

This is a course project. The repo also has a second entry screen (`DetailActivity`) that's declared in the manifest, but nothing in the app opens it.
