# 🗑️ Deleted Things

This file documents code that was previously part of the project but has been removed. It's preserved here for reference or possible reuse.


---

## 🔧 Registries

### Deferred Registers

```java
// Create Deferred Registers for block, items, and creative tabs under the "silicon" namespace
public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
```

---

## 🧱 Example Block

### Block & BlockItem

```java
// Creates a new Block with ID "silicon:example_block"
public static final DeferredBlock<Block> EXAMPLE_BLOCK =
    BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

// Registers a corresponding BlockItem for the example block
public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
    ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
```

---

## 🍎 Example Item

### Food Item

```java
// Creates a new always-edible food item with nutrition and saturation
public static final DeferredItem<Item> EXAMPLE_ITEM =
    ITEMS.registerSimpleItem("example_item", new Item.Properties().food(
        new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(1)
            .saturationModifier(2f)
            .build()
    ));
```

---

## 🧭 Example Creative Tab

```java
// Creates a creative tab with ID "silicon:example_tab"
public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
    CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.examplemod")) // Lang key
        .withTabsBefore(CreativeModeTabs.COMBAT)
        .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
        .displayItems((parameters, output) -> {
            output.accept(EXAMPLE_ITEM.get()); // Display item in tab
        })
        .build());
```

---

## 🪄 Registration (Init Code)

```java
// Register deferred registers to mod event bus
BLOCKS.register(modEventBus);
ITEMS.register(modEventBus);
CREATIVE_MODE_TABS.register(modEventBus);
```

---

## 🧪 Logging Sample (Setup Phase)

```java
if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
    LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
}

LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

Config.ITEM_STRINGS.get().forEach(item ->
    LOGGER.info("ITEM >> {}", item)
);
```

---

## ⚙️ Old Config (`Config.java`)

```java
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
        .comment("Whether to log the dirt block on common setup")
        .define("logDirtBlock", true);

    public static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER
        .comment("A magic number")
        .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
        .comment("What you want the introduction message to be for the magic number")
        .define("magicNumberIntroduction", "The magic number is... ");

    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
        .comment("A list of items to log on common setup.")
        .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName &&
               BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
```