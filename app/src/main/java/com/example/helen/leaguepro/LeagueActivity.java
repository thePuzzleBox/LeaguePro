package com.example.helen.leaguepro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import android.content.Intent;

import android.media.MediaPlayer;


public class LeagueActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);


        GridView gridView = findViewById(R.id.gridview);
        final ChampionAdapter championAdapter = new ChampionAdapter(this, champions);
        gridView.setAdapter(championAdapter);


        getSupportActionBar().setDisplayShowHomeEnabled(true);                          // LOL Logo in ActionBar
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);



        final MediaPlayer click = MediaPlayer.create(LeagueActivity.this, R.raw.mastery4);


        //  onClick navigates to next page -> Champion's Bio

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {


                MediaPlayer voiceline = MediaPlayer.create(LeagueActivity.this, champions[position].getLineResource());

                click.start();



                // Sends the position clicked to ChampionActivity to display right Champ

                Intent intent = new Intent(LeagueActivity.this, ChampionActivity.class);
                intent.putExtra("Champion Index", position);
                startActivity(intent);


                voiceline.start();

            }
        });

    }



    public static Champion[] champions = {


            new Champion("Aurelion Sol", "The Star Forger", "Nmxd0xVdAnU", R.drawable.asol, R.raw.asol1, R.raw.asol, "Aurelion Sol once graced the vast emptiness of the cosmos with celestial wonders of his own devising. Now, he is forced to wield his awesome power at the behest of a space-faring empire that tricked him into servitude. Desiring a return to his star-forging ways, Aurelion Sol will drag the very stars from the sky, if he must, in order to regain his freedom.\n" + "\n" + "The being now known as Aurelion Sol was already ancient by the time stellar debris first coalesced into worlds."),

            new Champion("Annie", "The Dark Child","UTTLsBb9NN8",R.drawable.annie, R.raw.annie1, R.raw.annie, "Dangerous, yet disarmingly precocious, Annie is a child mage with immense pyromantic power. Even in the shadows of the mountains north of Noxus, she is a magical outlier. Her natural affinity for fire manifested early in life through unpredictable, emotional outbursts, though she eventually learned to control these playful tricks.\n" + "\n" + "Kept safe by Tibbers, she wanders the dark forests of Noxus, oblivious to danger—and the dangers posed to others by her own unchecked power—hoping, one day, to find someone like her to play with." ),

            new Champion("Caitlyn", "The Sheriff of Piltover", "0TnqBtjmoqQ", R.drawable.cait, R.raw.cait1, R.raw.cait,"Renowned as its finest peacekeeper, Caitlyn is also Piltover’s best shot at ridding the city of its elusive criminal elements. She is often paired with Vi, acting as a cool counterpoint to her partner’s more impetuous nature.\n" + "\n" + "Even though she carries a one-of-a-kind hextech rifle, Caitlyn’s most powerful weapon is her superior intellect, allowing her to lay elaborate traps for any lawbreakers foolish enough to operate in the City of Progress."),

            new Champion("Camille", "The Steel Shadow","YaNANTQH0zc", R.drawable.camille, R.raw.camille1, R.raw.camille, "Weaponized to operate outside the boundaries of the law, Camille is the Principal Intelligencer of Clan Ferros—an elegant and elite agent who ensures the Piltover machine and its Zaunite underbelly runs smoothly.\n" + "\n" + "Adaptable and precise, she views sloppy technique as an embarrassment that must be put to order. With a mind as sharp as the blades she bears, Camille's pursuit of superiority through hextech body augmentation has left many to wonder if she is now more machine than woman."),

            new Champion("Ekko", "The Boy Who Shattered Time","Tq2kCC2YIdo", R.drawable.ekko, R.raw.ekko1, R.raw.ekko, "A prodigy from the rough streets of Zaun, Ekko manipulates time to twist any situation to his advantage. Using his own invention, the Zero Drive, he explores the branching possibilities of reality to craft the perfect moment.\n" + "\n" + "Though he revels in this freedom, when there’s a threat to his friends he’ll do anything to defend them. To outsiders, Ekko seems to achieve the impossible the first time, every time."),

            new Champion("Fiddlesticks", "The Harbinger of Doom","pDq6FMtImL0", R.drawable.fiddle, R.raw.fiddle1, R.raw.fiddle, "Fiddlesticks is a ghastly, living scarecrow who stalks the darkness, wielding a cruel scythe and preying upon the unwary. Once a lonely man accused of bringing famine to his village, he was tied up and left to starve in his own barren field.\n" + "\n" + "Resurrected by the savage murder of crows that fed on his remains, Fiddlesticks now relishes terrorizing his victims before claiming their lives amid a flurry of feathers and blood-splattered beaks."),

            new Champion("Garen", "The Might of Demacia","Ly-rlSE-_8Q", R.drawable.garen, R.raw.garen1,R.raw.garen, "A proud and noble warrior, Garen fights as one of the Dauntless Vanguard. He is popular among his fellows, and respected well enough by his enemies—not least as a scion of the prestigious Crownguard family, entrusted with defending Demacia and its ideals.\n" + "\n" + "Clad in magic-resistant armor and bearing a mighty broadsword, Garen stands ready to confront mages and sorcerers on the field of battle, in a veritable whirlwind of righteous steel."),

            new Champion("Heimerdinger", "The Revered Inventor","NiAsHs_EHdE", R.drawable.heim, R.raw.heim1, R.raw.heim, "A brilliant yet eccentric yordle scientist, Professor Cecil B. Heimerdinger is one of the most innovative and esteemed inventors Piltover has ever known. Relentless in his work to the point of neurotic obsession, he thrives on answering the universe’s most impenetrable questions.\n" + "\n" + "Though his theories often appear opaque and esoteric, Heimerdinger has crafted some of Piltover’s most miraculous—not to mention lethal—machinery, and constantly tinkers with his inventions to make them even more efficient."),

            new Champion("Ivern", "The Green Father","DLTQZNZwZsw", R.drawable.ivern, R.raw.ivern1, R.raw.ivern, "Ivern Bramblefoot, known to many as the Green Father, is a peculiar half man, half tree who roams Runeterra’s forests, cultivating life everywhere he goes. He knows the secrets of the natural world, and holds deep friendships with all things that grow, fly, and scuttle.\n" +"" + "\n" + "Ivern wanders the wilderness, imparting strange wisdom to any he meets, enriching the forests, and occasionally entrusting loose-lipped butterflies with his secrets."),

            new Champion("Jhin", "The Virtuoso", "UfFGzPJtk6g", R.drawable.jhin, R.raw.jhin1, R.raw.jhin, "Jhin is a meticulous criminal psychopath who believes murder is art. Once an Ionian prisoner, but freed by shadowy elements within Ionia’s ruling council, the serial killer now works as their cabal's assassin.\n" + "\n" + "Using his gun as his paintbrush, Jhin creates works of artistic brutality, horrifying victims and onlookers. He gains a cruel pleasure from putting on his gruesome theater, making him the ideal choice to send the most powerful of messages: terror."),

            new Champion("Kled", "The Cantankerous Cavalier","KdpoZI1RxRQ", R.drawable.kled, R.raw.kled1, R.raw.kled, "A warrior as fearless as he is ornery, the yordle Kled embodies the furious bravado of Noxus. He is an icon beloved by the empire’s soldiers, distrusted by its officers, and loathed by the nobility. Many claim Kled has fought in every campaign the legions have waged, has “acquired” every military title, and has never once backed down from a fight.\n" + "\n" + "Though the truth of the matter is often questionable, one part of his legend is undeniable: Charging into battle on his un-trusty steed, Skaarl, Kled fights to protect what’s his… and to take whatever he can get."),

            new Champion("Lux", "The Lady of Luminosity","6yaXkVYwfu4", R.drawable.lux, R.raw.lux1, R.raw.lux, "Luxanna Crownguard hails from Demacia, an insular realm where magical abilities are viewed with fear and suspicion. Able to bend light to her will, she grew up dreading discovery and exile, and was forced to keep her power secret, in order to preserve her family’s noble status.\n" + "\n" + "Nonetheless, Lux’s optimism and resilience have led her to embrace her unique talents, and she now covertly wields them in service of her homeland."),

            new Champion("Master Yi", "The Wuju Bladesman","jB1XvMyEBNA", R.drawable.yi, R.raw.yi1, R.raw.yi, "Master Yi has tempered his body and sharpened his mind, so that thought and action have become almost as one. Though he chooses to enter into violence only as a last resort, the grace and speed of his blade ensures resolution is always swift.\n" + "\n" + "As one of the last living practitioners of the Ionian art of Wuju, Yi has devoted his life to continuing the legacy of his people—scrutinizing potential new disciples with the Seven Lenses of Insight to identify the most worthy among them"),

            new Champion("Miss Fortune", "The Bounty Hunter","kLqf8cq6FEA", R.drawable.mf, R.raw.mf1, R.raw.mf, "A Bilgewater captain famed for her looks but feared for her ruthlessness, Sarah Fortune paints a stark figure among the hardened criminals of the port city. As a child, she witnessed the reaver king Gangplank murder her family—an act she brutally avenged years later, blowing up his flagship while he was still aboard.\n" + "\n" + "Those who underestimate her will face a beguiling and unpredictable opponent… and, likely, a bullet or two in their guts."),

            new Champion("Nunu & Willump", "The Boy and His Yeti", "xaaJbFxpfyE", R.drawable.nunu, R.raw.nunu1, R.raw.nunu,"Once upon a time, there was a boy who wanted to prove he was a hero by slaying a fearsome monster—only to discover that the beast, a lonely and magical yeti, merely needed a friend./n" + "\n" + "Bound together by ancient power and a shared love of snowballs, Nunu and Willump now ramble wildly across the Freljord, breathing life into imagined adventures. They hope that somewhere out there, they will find Nunu’s mother. If they can save her, maybe they will be heroes after all…"),

            new Champion("Ornn", "The Fire below the Mountain","MgeoYqzsVq8", R.drawable.ornn, R.raw.ornn1, R.raw.ornn,"Ornn is the Freljordian spirit of forging and craftsmanship. He works in the solitude of a massive smithy, hammered out from the lava caverns beneath the volcano Hearth-Home. There he stokes bubbling cauldrons of molten rock to purify ores and fashion items of unsurpassed quality.\n" + "\n" + "When other deities—especially Volibear—walk the earth and meddle in mortal affairs, Ornn arises to put these impetuous beings back in their place, either with his trusty hammer or the fiery power of the mountains themselves."),

            new Champion("Rakan", "The Charmer","jvHNZLWX--A", R.drawable.rakan, R.raw.rakan1, R.raw.rakan,"As mercurial as he is charming, Rakan is an infamous vastayan troublemaker and the greatest battle-dancer in Lhotlan tribal history. To the humans of the Ionian highlands, his name has long been synonymous with wild festivals, uncontrollable parties, and anarchic music.\n" + "\n" + "Few would suspect this energetic, traveling showman is also partner to the rebel Xayah, and is dedicated to her cause."),

            new Champion("Rengar", "The Pridestalker", "zEbmxcBMI0w", R.drawable.rengar, R.raw.rengar1, R.raw.rengar,"Rengar is a ferocious vastayan trophy hunter who lives for the thrill of tracking down and killing dangerous creatures.\n" + "\n" + "He scours the world for the most fearsome beasts he can find, especially seeking any trace of Kha’Zix, the void creature who scratched out his eye. Rengar stalks his prey neither for food nor glory, but for the sheer beauty of the pursuit."),

            new Champion("Swain", "The Noxian Grand General", "ltZoM_XGKUg", R.drawable.swain, R.raw.swain1, R.raw.swain, "Jericho Swain is the visionary ruler of Noxus, an expansionist nation that reveres only strength. Though he was cast down and crippled in the Ionian wars, his left arm severed, he seized control of the empire with ruthless determination… and a new, demonic hand.\n" + "\n" + "Now, Swain commands from the front lines, marching against a coming darkness that only he can see—in glimpses gathered by shadowy ravens from the corpses all around him. In a swirl of sacrifice and secrets, the greatest secret of all is that the true enemy lies within."),

            new Champion("Taliyah", "The Stoneweaver", "vuImKTZhVvY", R.drawable.taliyah, R.raw.taliyah1, R.raw.taliyah, "Taliyah is a nomadic mage from Shurima, torn between teenage wonder and adult responsibility. She has crossed nearly all of Valoran on a journey to learn the true nature of her growing powers, though more recently she has returned to protect her tribe.\n" + "\n" + "Some have mistaken her compassion for weakness and paid the ultimate price—for beneath Taliyah’s youthful demeanor is a will strong enough to move mountains, and a spirit fierce enough to make the earth itself tremble."),

            new Champion("Taric", "The Shield Of Valoran","D6gA50f-Hzk", R.drawable.taric, R.raw.taric1, R.raw.taric, "Taric is the Aspect of the Protector, wielding incredible power as Runeterra’s guardian of life, love, and beauty. Shamed by a dereliction of duty and exiled from his homeland Demacia, Taric ascended Mount Targon to find redemption, only to discover a higher calling among the stars.\n" + "\n" + "Imbued with the might of ancient Targon, the Shield of Valoran now stands ever vigilant against the insidious corruption of the Void."),

            new Champion("Teemo", "The Swift Scout","rmRbvNiQ28g", R.drawable.tmo, R.raw.tmo1, R.raw.tmo , "Undeterred by even the most dangerous and threatening of obstacles, Teemo scouts the world with boundless enthusiasm and a cheerful spirit. A yordle with an unwavering sense of morality, he takes pride in following the Bandle Scout's Code, sometimes with such eagerness that he is unaware of the broader consequences of his actions.\n" + "\n" + "Though some say the existence of the Scouts is questionable, one thing is for certain: Teemo's conviction is nothing to be trifled with."),

            new Champion("Thresh", "The Chain Warden","s2FFGBPXNeU", R.drawable.thresh, R.raw.thresh1, R.raw.thresh, "Sadistic and cunning, Thresh is an ambitious and restless spirit of the Shadow Isles. Once the custodian of countless arcane secrets, he sought a power greater than life or death, and now sustains himself by tormenting and breaking others with slow, excruciating inventiveness.\n" + "\n" + "His victims suffer far beyond their brief mortal coil as Thresh wreaks agony upon their souls, imprisoning them in his unholy lantern to torture for all eternity."),

            new Champion("Twisted Fate", "The Card Master","gRY9rIWvbjs", R.drawable.tf, R.raw.tf1, R.raw.tf, "Twisted Fate is an infamous cardsharp and swindler who has gambled and charmed his way across much of the known world, earning the enmity and admiration of the rich and foolish alike.\n" + "\n" + "He rarely takes things seriously, greeting each day with a mocking smile and an insouciant swagger. In every possible way, Twisted Fate always has an ace up his sleeve."),

            new Champion("Udyr", "The Spirit Walker","xVQEPayBHsk", R.drawable.udyr, R.raw.udyr1, R.raw.udyr,"Udyr is more than a man; he is a vessel for the untamed power of four primal animal spirits.\n" + "\n" + "When tapping into the spirits' bestial natures, Udyr can harness their unique strengths: The tiger grants him speed and ferocity, the turtle resilience, the bear might, and the phoenix its eternal flame. With their combined power, Udyr can turn back all those who would attempt to harm the natural order."),

            new Champion("Xayah", "The Rebel","O4PDzBnBMU4", R.drawable.xayah, R.raw.xayah1, R.raw.xayah, "Deadly and precise, Xayah is a vastayan revolutionary waging a personal war to save her people. She uses her speed, guile, and razor-sharp feather blades to cut down anyone who stands in her way.\n" + "\n" + "Xayah fights alongside her partner and lover, Rakan, to protect their dwindling tribe, and restore their race to her vision of its former glory."),

            new Champion("Yasuo", "The Unforgiven", "QnXep4UFdf4", R.drawable.yasuo, R.raw.yasuo1, R.raw.yasuo, "An Ionian of deep resolve, Yasuo is an agile swordsman who wields the air itself against his enemies. As a proud young man, he was falsely accused of murdering his master—unable to prove his innocence, he was forced to slay his own brother in self defense.\n" +"\n" + "Even after his master’s true killer was revealed, Yasuo still could not forgive himself for all he had done, and now wanders his homeland with only the wind to guide his blade."),

            new Champion("Zed", "The Master of Shadows", "aAVMDqyCDgU", R.drawable.zed, R.raw.zed1, R.raw.zed, "Utterly ruthless and without mercy, Zed is the leader of the Order of Shadow, an organization he created with the intent of militarizing Ionia’s magical and martial traditions to drive out Noxian invaders.\n" + "\n" + "During the war, desperation led him to unlock the secret shadow form—a malevolent spirit magic as dangerous and corrupting as it is powerful. Zed has mastered all of these forbidden techniques to destroy anything he sees as a threat to his nation, or his new order."),

            new Champion("Ziggs", "The Hexplosives Expert","E0jIyq5UGuI", R.drawable.ziggs, R.raw.ziggs1, R.raw.ziggs, "With a love of big bombs and short fuses, the yordle Ziggs is an explosive force of nature. As an inventor’s assistant in Piltover, he was bored by his predictable life and befriended a mad, blue-haired bomber named Jinx.\n" + "\n" + "After a wild night on the town, Ziggs took her advice and moved to Zaun, where he now explores his fascinations more freely, terrorizing the chem-barons and regular citizens alike in his never ending quest to blow stuff up."),

            new Champion("Zoe", "The Aspect of Twilight","dofpb8mDi6E", R.drawable.zoe, R.raw.zoe1, R.raw.zoe, "As the embodiment of mischief, imagination, and change, Zoe acts as the cosmic messenger of Targon, heralding major events that reshape worlds. Her mere presence warps the arcane mathematics governing realities, sometimes causing cataclysms without conscious effort or malice.\n" + "\n" + "This perhaps explains the breezy nonchalance with which Zoe approaches her duties, giving her plenty of time to focus on playing games, tricking mortals, or otherwise amusing herself. An encounter with Zoe can be joyous and life affirming, but it is always more than it appears and often extremely dangerous.")
    };
}
