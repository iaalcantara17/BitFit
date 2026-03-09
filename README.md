# Android Project 6 - BitFit Part 2

Submitted by: **Israel Alcantara**

**BitFit** is a health metrics app that allows users to track their daily sleep hours, morning feeling (1-10), notes, and photos with persistent storage, summary statistics, trend graphs, and daily reminder notifications.

Time spent: **4** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **Use at least 2 Fragments**
- [x] **Create a new dashboard fragment where users can see a summary of their entered data**
- [x] **Use one of the Navigation UI Views (BottomNavigation, Drawer Layout, Top Bar) to move between the fragments**

The following **optional** features are implemented:

- [x] **Add a more advanced UI (e.g: Graphing) for tracking trends in metrics**
- [x] **Implement daily notifications to prompt users to fill in their data**

The following **additional** features are implemented:

- [x] MPAndroidChart LineChart for sleep trend visualization
- [x] MPAndroidChart BarChart for feeling trend visualization
- [x] Daily photo attachment with Glide rendering
- [x] Boot-persistent notification scheduling via BroadcastReceiver
- [x] Material Design cards on the Dashboard for a polished look
- [x] Empty state messaging when no entries exist yet

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src="./BitFit.gif" title="Video Walkthrough" width="300" alt="Video Walkthrough" />

GIF created with ScreenToGif

## Notes

The main challenge was migrating the entry form and RecyclerView logic from MainActivity into LogFragment, making sure the photo picker (registerForActivityResult) was registered in onCreate() of the fragment rather than onViewCreated(). Setting up the navigation graph and ensuring the menu item IDs exactly matched the fragment IDs in nav_graph.xml was also a key detail. Integrating MPAndroidChart required adding the JitPack repository to settings.gradle.kts.

## License

    Copyright 2026 Israel Alcantara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
