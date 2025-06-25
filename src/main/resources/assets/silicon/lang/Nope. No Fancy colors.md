{
  "item.silicon.bismuth": [
      {"text":"B","color":"#09B1A9","bold":true},
      {"text":"i","color":"#24B59C","bold":true},
      {"text":"s","color":"#3FB98F","bold":true},
      {"text":"m","color":"#5BBD83","bold":true},
      {"text":"u","color":"#76C076","bold":true},
      {"text":"t","color":"#91C469","bold":true},
      {"text":"h","color":"#ACC85C","bold":true}
  ],

  "item.silicon.raw_bismuth": [
    "Raw ",
    { "translate": "item.silicon.bismuth" }
  ],

  "item.silicon.chisel": "Chisel",

  "item.silicon.redish": "Radish",

  "item.silicon.redish.tooltip": [

  ],

Installation information
=======

This template repository can be directly cloned to get you started with a new
mod. Simply create a new repository cloned from this one, by following the
instructions provided by [GitHub](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything
{this does not affect your code} and then start the process again.

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources:
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/



  "item.silicon.frostfire_ice": [
    {"text":"F","color":"#1E09B1"},
    {"text":"r","color":"#222BB1"},
    {"text":"o","color":"#264DB1"},
    {"text":"s","color":"#296FB1"},
    {"text":"t","color":"#2D91B1"},

    {"text":"f","color":"#FF0000"},
    {"text":"i","color":"#FE451D"},
    {"text":"r","color":"#FE8A3B"},
    {"text":"e","color":"#FDCF58"},

    {"text":"I","color":"#72C6EF"},
    {"text":"c","color":"#398ABF"},
    {"text":"e","color":"#004E8F"}
  ],

  "item.silicon.starlight_ashes": [
    {"text":"S","color":"#FF0000"},
    {"text":"t","color":"#FE451D"},
    {"text":"a","color":"#FE8A3B"},
    {"text":"r","color":"#FDCF58"},
    {"text":"l","color":"#003973"},
    {"text":"i","color":"#396486"},
    {"text":"g","color":"#738F99"},
    {"text":"h","color":"#ACBAAB"},
    {"text":"t","color":"#E5E5BE"},
    {"text":"A","color":"#0F2027"},
    {"text":"s","color":"#182D35"},
    {"text":"h","color":"#203A43"},
    {"text":"e","color":"#264754"},
    {"text":"s","color":"#2C5364"}
  ],


  "block.silicon.bismuth_block": [
    "Block of ",
    {"translate": "item.silicon.bismuth"}
  ],

  "block.silicon.bismuth_ore": [
    {"translate": "item.silicon.bismuth"},
    " Ore"
  ],

  "block.silicon.bismuth_deepslate_ore": [
    "Deepslate ",
    {"translate": "block.silicon.bismuth_ore"}
  ],

  "block.silicon.magic_block": [
    {"text":"M","color":"#A17FE0"},
    {"text":"a","color":"#9069D8"},
    {"text":"g","color":"#7F53D1"},
    {"text":"i","color":"#6E3CC9"},
    {"text":"c","color":"#5D26C1"},
    " Block"
  ],

  "creativetab.silicon.bismuth_item_tab": [
    "Item ",
    {"translate": "item.silicon.bismuth"}
  ],

  "creativetab.silicon.bismuth_block_tab": [
    "Block ",
    {"translate": "item.silicon.bismuth"}
  ]
}