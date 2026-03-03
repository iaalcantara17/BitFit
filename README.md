# Android Project 5 - BitFit

Submitted by: **Israel Alcantara**

**BitFit** is a health metrics app that allows users to track their daily sleep, mood, and notes with persistent storage and data visualization.

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **At least one health metric is tracked (based on user input)**
  - Chosen metric(s): `Sleep Hours`, `Morning Feeling (1-10)`
- [x] **There is a "create entry" UI that prompts users to make their daily entry**
- [x] **New entries are saved in a database and then updated in the RecyclerView**
- [x] **On application restart, previously entered entries are preserved (i.e., are *persistent*)**
 
The following **optional** features are implemented:

- [x] **Create a UI for tracking averages and trends in metrics**
- [x] **Improve and customize the user interface through styling and coloring**
- [x] **Implement orientation responsivity**
- [x] **Add a daily photo feature**

The following **additional** features are implemented:

- [x] Custom green theme and dashboard card for quick insights.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with ScreenToGif

## Notes

Implementing the Room migration and ensuring the UI updated reactively with Flow were the main challenges. Integrating the photo picker with Glide also required careful handling of URIs.

## License

    Copyright 2024 Israel Alcantara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
