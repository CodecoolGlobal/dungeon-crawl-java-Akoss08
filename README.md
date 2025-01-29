<a id="readme-top"></a>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08">
    <img src="src/main/resources/gameImages/Screenshot 2025-01-29 125049.png" alt="Logo" width="90" height="90">
  </a>

<h3 align="center">Dungeon Crawl</h3>

  <p align="center">
Fight, Level Up, Upgrade, Complete Quests, and Discover New Worlds!
    <br />
    <a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08">View Demo</a>
    &middot;
    <a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#main-features">Main Features</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
    <a href="#usage">Usage</a>
      <ul>
        <li><a href="#example-monsters-movement">Example</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

<img src="/src/main/resources/gameImages/Screenshot 2025-01-29 134909.png" width="600" height="400">

Welcome to Dungeon Crawl game!

Embark on an epic dungeon-crawling adventure where danger lurks in every shadow! In Dungeon Crawl, you’ll explore various maps, battle evil monsters, and uncover hidden treasures. Upgrade your character with powerful weapons and armor, complete thrilling quests, and interact with NPCs like shopkeepers to gear up for the challenges ahead.

Face off against formidable bosses with special abilities, and level up to become the ultimate dungeon warrior! Do you have what it takes to survive the depths and claim victory?
### Main Features:

🔹 <u><i>Explore Diverse Dungeons:</i></u> Each map is filled with secrets, enemies, and rewards.

⚔️ <u><i>Battle Dangerous Monsters:</u></i> Gain experience and level up by defeating a variety of powerful creatures.

🛡️ <u><i>Upgrade Your Character:</u></i> Equip different weapons and armor to upgrade your character.

🎒 <u><i>Loot & Collect:</u></i> Open chests, find items that boost your hero.

🛒 <u><i>Interact with NPCs:</u></i> Visit shopkeepers, take on quests, and uncover the world’s lore.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

This game is built with Java and Maven, featuring immersive dungeon exploration, strategic battle mechanics, and a dynamic world powered by JavaFX. Ready to dive into the depths and conquer the dungeons?

- [![Java][Java]][Java-url]
- [![JavaFx][JavaFx]][JavaFx-url]
- [![Maven][Maven]][Maven-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

This is an example of how to set up the Dungeon Crawl Game locally.

### Prerequisites

Before running the game, ensure you have the following:

- **Java 17 or later:** Required to run the game. You can download it from <a href="https://www.oracle.com/java/technologies/downloads/">here</a>.
- **Apache Maven (_if using the command line_):** If you're running the game from a terminal, install Maven from <a href="https://maven.apache.org/download.cgi">maven.apache.org.</a>


- **Using IntelliJ IDEA?** No need to install Maven separately—it comes bundled with IntelliJ. Just open the **_pom.xml_** file as a project.

### Installation

_Follow these simple steps to get the project up and running on your machine._

#### For Command Line Users:

1. Clone the repo
   ```sh
   git clone https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08.git
   ```
2. Navigate to the project folder
   ```sh
   cd dungeon-crawl-java-Akoss08
   ```
3. Compile the Project (_this installs dependencies and compiles the code_)
   ```sh
   mvn compile
   ```
4. Run the application to play the game!
   ```sh
   mvn javafx:run
   ```
#### For IntelliJ IDEA Users:

1. Clone the repo
   ```sh
   git clone https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08.git
   ```
2. Open the pom.xml File in IntelliJ as a project
</br>

<img src="src/main/resources/gameImages/Screenshot 2025-01-29 160101.png">

3. Run the Application

- Once the project is open, find the App class (_src.main.java.com.codecool.dungeoncrawl_).
  Right-click the class and select Run 'App.main()'.
</br>

<img src="src/main/resources/gameImages/Screenshot 2025-01-29 162341.png">


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->

## Usage

Once you have the game running, you can explore different dungeons, battle monsters, collect loot, and level up your character! Here’s how you play:

1. **Instructions**: 

<img src="src/main/resources/gameImages/Screenshot 2025-01-29 164755.png">

- A — attack enemy
- O — open chest
- H — use healing potion (_restore max health_)
- P — use power potion (_add +3 strength for the next 3 attack_)
- I — talk to NPCs

2. **Explore Dungeons**: Move your character through the maps by using the keyboard. Explore dungeons and uncover treasures as you progress.


3. **Fight Monsters**: As you approach a monster, you’ll have the option to attack it. The outcome of the battle depends on your character's and the monster's stats (like health, attack, and defense).


4. **Monster Abilities**: Monsters you encounter may have special abilities such as poisoning you, attacking immediately, teleporting, or splitting into multiple enemies. Be strategic and make sure to manage your resources wisely to handle these surprises.


5. **Loot and Upgrade**: After defeating monsters, you may find loot such as gold, weapons, armor or healing potions. Use these items to improve your character’s stats and prepare for tougher battles ahead.


6. **Level Up**: As you defeat monsters and complete quests, you’ll gain experience points (XP). Leveling up increases your character’s stats, making them stronger and more capable of handling difficult enemies and dungeons.


7. **Complete Quests**: Along your journey, you’ll meet NPCs who might give you quests and sell you items. Take on quests to earn rewards and progress through the game!


8. **Defeat Bosses**: Within the game, you’ll encounter powerful bosses with unique abilities. These are some of the toughest challenges in the game, so use your upgraded equipment, stats, and careful strategy to take them down!

### Example: Monsters movement

Here’s a simplified snippet of how the monsters are moving on the map:

```java
public void move(int dx, int dy) {
   Cell nextCell = cell.getNeighbor(dx, dy);

   if (nextCell.isWalkable() && !isDead) {
      cell.setActor(null);
      nextCell.setActor(this);
      cell = nextCell;
   }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

This project is currently read-only and not open to external contributions.
However, feel free to fork the repository for personal use or exploration.

Don't forget to give the project a star if you like it! 🌟

### Top contributors:

!NEED TO CHANGE AFTER PUBLIC ON CONTRIB.ROCKS!
<a href="https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/graphs/contributors">
<img src="https://contrib.rocks/image?repo=MAdem01/el-proyecte-grande-sprint-1" />
</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

Akos Horvath - [LinkedIn](https://www.linkedin.com/in/akos-horvath97/) - akos97@gmail.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

We’d like to take a moment to thank the resources and tools that helped us bring this Dungeon Crawl game to life:

- [JavaFX][JavaFx-url] – For providing a rich set of tools for building the game's graphical user interface.
- [Maven][Maven-url] – For simplifying project management, dependencies, and build processes.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) – For being the powerful IDE that made coding and debugging more efficient.
- [Shields.io](https://shields.io) – For generating beautiful badges used in the README
- [GitHub Pages](https://pages.github.com) – For hosting and sharing the game with the world

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/CodecoolGlobal/dungeon-crawl-java-Akoss08.svg?style=for-the-badge
[contributors-url]: https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CodecoolGlobal/dungeon-crawl-java-Akoss08.svg?style=for-the-badge
[forks-url]: https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/network/members
[stars-shield]: https://img.shields.io/github/stars/CodecoolGlobal/dungeon-crawl-java-Akoss08.svg?style=for-the-badge
[stars-url]: https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/stargazers
[issues-shield]: https://img.shields.io/github/issues/CodecoolGlobal/dungeon-crawl-java-Akoss08.svg?style=for-the-badge
[issues-url]: https://github.com/CodecoolGlobal/dungeon-crawl-java-Akoss08/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/akos-horvath97/
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/en/
[JavaFx]: https://img.shields.io/badge/JavaFX-17-%23006400
[JavaFx-url]: https://openjfx.io/
[Maven]: https://img.shields.io/badge/Apache%20Maven-000000?style=for-the-badge&logo=apachemaven&logoColor=blue
[Maven-url]: https://maven.apache.org/
