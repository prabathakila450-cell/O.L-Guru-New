package com.example

/**
 * 🔤 Voice Quiz Bank for English
 * 200 strictly simple, direct, vocabulary and grammar oral exam questions.
 * 10 distinct sets of 20 questions each.
 */
object VoiceQuizEnglishBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return getGrade11Question(setNum, qIndex, theme)
    }
    return when (setNum) {
      // Set 1: Opposites (Antonyms)
      1 -> when (qIndex) {
        1 -> Quintuple("What is the opposite of 'hot'?", "What is the opposite of 'hot'?", listOf("cold", "cool"), "Cold", "Opposite of hot is cold.")
        2 -> Quintuple("What is the opposite of 'big'?", "What is the opposite of 'big'?", listOf("small", "little"), "Small", "Opposite of big is small.")
        3 -> Quintuple("What is the opposite of 'happy'?", "What is the opposite of 'happy'?", listOf("sad", "unhappy"), "Sad", "Opposite of happy is sad.")
        4 -> Quintuple("What is the opposite of 'fast'?", "What is the opposite of 'fast'?", listOf("slow"), "Slow", "Opposite of fast is slow.")
        5 -> Quintuple("What is the opposite of 'tall'?", "What is the opposite of 'tall'?", listOf("short"), "Short", "Opposite of tall is short.")
        6 -> Quintuple("What is the opposite of 'day'?", "What is the opposite of 'day'?", listOf("night"), "Night", "Opposite of day is night.")
        7 -> Quintuple("What is the opposite of 'up'?", "What is the opposite of 'up'?", listOf("down"), "Down", "Opposite of up is down.")
        8 -> Quintuple("What is the opposite of 'rich'?", "What is the opposite of 'rich'?", listOf("poor"), "Poor", "Opposite of rich is poor.")
        9 -> Quintuple("What is the opposite of 'heavy'?", "What is the opposite of 'heavy'?", listOf("light"), "Light", "Opposite of heavy is light.")
        10 -> Quintuple("What is the opposite of 'good'?", "What is the opposite of 'good'?", listOf("bad"), "Bad", "Opposite of good is bad.")
        11 -> Quintuple("What is the opposite of 'empty'?", "What is the opposite of 'empty'?", listOf("full"), "Full", "Opposite of empty is full.")
        12 -> Quintuple("What is the opposite of 'young'?", "What is the opposite of 'young'?", listOf("old"), "Old", "Opposite of young is old.")
        13 -> Quintuple("What is the opposite of 'hard'?", "What is the opposite of 'hard'?", listOf("soft", "easy"), "Soft", "Opposite of hard is soft.")
        14 -> Quintuple("What is the opposite of 'near'?", "What is the opposite of 'near'?", listOf("far"), "Far", "Opposite of near is far.")
        15 -> Quintuple("What is the opposite of 'early'?", "What is the opposite of 'early'?", listOf("late"), "Late", "Opposite of early is late.")
        16 -> Quintuple("What is the opposite of 'dark'?", "What is the opposite of 'dark'?", listOf("light", "bright"), "Light", "Opposite of dark is light.")
        17 -> Quintuple("What is the opposite of 'push'?", "What is the opposite of 'push'?", listOf("pull"), "Pull", "Opposite of push is pull.")
        18 -> Quintuple("What is the opposite of 'easy'?", "What is the opposite of 'easy'?", listOf("difficult", "hard"), "Difficult", "Opposite of easy is difficult.")
        19 -> Quintuple("What is the opposite of 'clean'?", "What is the opposite of 'clean'?", listOf("dirty"), "Dirty", "Opposite of clean is dirty.")
        20 -> Quintuple("What is the opposite of 'win'?", "What is the opposite of 'win'?", listOf("lose"), "Lose", "Opposite of win is lose.")
        else -> Quintuple("What is the opposite of 'in'?", "What is the opposite of 'in'?", listOf("out"), "Out", "Opposite of in is out.")
      }

      // Set 2: Plurals
      2 -> when (qIndex) {
        1 -> Quintuple("What is the plural of 'child'?", "What is the plural of 'child'?", listOf("children"), "Children", "Plural of child is children.")
        2 -> Quintuple("What is the plural of 'man'?", "What is the plural of 'man'?", listOf("men"), "Men", "Plural of man is men.")
        3 -> Quintuple("What is the plural of 'woman'?", "What is the plural of 'woman'?", listOf("women"), "Women", "Plural of woman is women.")
        4 -> Quintuple("What is the plural of 'foot'?", "What is the plural of 'foot'?", listOf("feet"), "Feet", "Plural of foot is feet.")
        5 -> Quintuple("What is the plural of 'tooth'?", "What is the plural of 'tooth'?", listOf("teeth"), "Teeth", "Plural of tooth is teeth.")
        6 -> Quintuple("What is the plural of 'mouse'?", "What is the plural of 'mouse'?", listOf("mice"), "Mice", "Plural of mouse is mice.")
        7 -> Quintuple("What is the plural of 'leaf'?", "What is the plural of 'leaf'?", listOf("leaves"), "Leaves", "Plural of leaf is leaves.")
        8 -> Quintuple("What is the plural of 'knife'?", "What is the plural of 'knife'?", listOf("knives"), "Knives", "Plural of knife is knives.")
        9 -> Quintuple("What is the plural of 'city'?", "What is the plural of 'city'?", listOf("cities"), "Cities", "Plural of city is cities.")
        10 -> Quintuple("What is the plural of 'baby'?", "What is the plural of 'baby'?", listOf("babies"), "Babies", "Plural of baby is babies.")
        11 -> Quintuple("What is the plural of 'box'?", "What is the plural of 'box'?", listOf("boxes"), "Boxes", "Plural of box is boxes.")
        12 -> Quintuple("What is the plural of 'watch'?", "What is the plural of 'watch'?", listOf("watches"), "Watches", "Plural of watch is watches.")
        13 -> Quintuple("What is the plural of 'person'?", "What is the plural of 'person'?", listOf("people"), "People", "Plural of person is people.")
        14 -> Quintuple("What is the plural of 'sheep'?", "What is the plural of 'sheep'?", listOf("sheep"), "Sheep", "Plural of sheep is sheep.")
        15 -> Quintuple("What is the plural of 'fish'?", "What is the plural of 'fish'?", listOf("fish"), "Fish", "Plural of fish is fish.")
        16 -> Quintuple("What is the plural of 'book'?", "What is the plural of 'book'?", listOf("books"), "Books", "Plural of book is books.")
        17 -> Quintuple("What is the plural of 'boy'?", "What is the plural of 'boy'?", listOf("boys"), "Boys", "Plural of boy is boys.")
        18 -> Quintuple("What is the plural of 'car'?", "What is the plural of 'car'?", listOf("cars"), "Cars", "Plural of car is cars.")
        19 -> Quintuple("What is the plural of 'key'?", "What is the plural of 'key'?", listOf("keys"), "Keys", "Plural of key is keys.")
        20 -> Quintuple("What is the plural of 'bus'?", "What is the plural of 'bus'?", listOf("buses"), "Buses", "Plural of bus is buses.")
        else -> Quintuple("What is the plural of 'cat'?", "What is the plural of 'cat'?", listOf("cats"), "Cats", "Plural of cat is cats.")
      }

      // Set 3: Past Tense
      3 -> when (qIndex) {
        1 -> Quintuple("What is the past tense of 'go'?", "What is the past tense of 'go'?", listOf("went"), "Went", "Past tense of go is went.")
        2 -> Quintuple("What is the past tense of 'eat'?", "What is the past tense of 'eat'?", listOf("ate"), "Ate", "Past tense of eat is ate.")
        3 -> Quintuple("What is the past tense of 'see'?", "What is the past tense of 'see'?", listOf("saw"), "Saw", "Past tense of see is saw.")
        4 -> Quintuple("What is the past tense of 'come'?", "What is the past tense of 'come'?", listOf("came"), "Came", "Past tense of come is came.")
        5 -> Quintuple("What is the past tense of 'do'?", "What is the past tense of 'do'?", listOf("did"), "Did", "Past tense of do is did.")
        6 -> Quintuple("What is the past tense of 'write'?", "What is the past tense of 'write'?", listOf("wrote"), "Wrote", "Past tense of write is wrote.")
        7 -> Quintuple("What is the past tense of 'buy'?", "What is the past tense of 'buy'?", listOf("bought"), "Bought", "Past tense of buy is bought.")
        8 -> Quintuple("What is the past tense of 'run'?", "What is the past tense of 'run'?", listOf("ran"), "Ran", "Past tense of run is ran.")
        9 -> Quintuple("What is the past tense of 'take'?", "What is the past tense of 'take'?", listOf("took"), "Took", "Past tense of take is took.")
        10 -> Quintuple("What is the past tense of 'give'?", "What is the past tense of 'give'?", listOf("gave"), "Gave", "Past tense of give is gave.")
        11 -> Quintuple("What is the past tense of 'make'?", "What is the past tense of 'make'?", listOf("made"), "Made", "Past tense of make is made.")
        12 -> Quintuple("What is the past tense of 'sleep'?", "What is the past tense of 'sleep'?", listOf("slept"), "Slept", "Past tense of sleep is slept.")
        13 -> Quintuple("What is the past tense of 'drink'?", "What is the past tense of 'drink'?", listOf("drank"), "Drank", "Past tense of drink is drank.")
        14 -> Quintuple("What is the past tense of 'sing'?", "What is the past tense of 'sing'?", listOf("sang"), "Sang", "Past tense of sing is sang.")
        15 -> Quintuple("What is the past tense of 'fly'?", "What is the past tense of 'fly'?", listOf("flew"), "Flew", "Past tense of fly is flew.")
        16 -> Quintuple("What is the past tense of 'drive'?", "What is the past tense of 'drive'?", listOf("drove"), "Drove", "Past tense of drive is drove.")
        17 -> Quintuple("What is the past tense of 'fall'?", "What is the past tense of 'fall'?", listOf("fell"), "Fell", "Past tense of fall is fell.")
        18 -> Quintuple("What is the past tense of 'speak'?", "What is the past tense of 'speak'?", listOf("spoke"), "Spoke", "Past tense of speak is spoke.")
        19 -> Quintuple("What is the past tense of 'know'?", "What is the past tense of 'know'?", listOf("knew"), "Knew", "Past tense of know is knew.")
        20 -> Quintuple("What is the past tense of 'play'?", "What is the past tense of 'play'?", listOf("played"), "Played", "Past tense of play is played.")
        else -> Quintuple("What is the past tense of 'walk'?", "What is the past tense of 'walk'?", listOf("walked"), "Walked", "Past tense of walk is walked.")
      }

      // Set 4: Calendar, Days & Time
      4 -> when (qIndex) {
        1 -> Quintuple("How many days are in a week?", "How many days in a week?", listOf("7", "seven"), "Seven (7) days", "There are 7 days.")
        2 -> Quintuple("Which day comes after Monday?", "Day after Monday?", listOf("tuesday"), "Tuesday", "Monday, then Tuesday.")
        3 -> Quintuple("Which day comes before Friday?", "Day before Friday?", listOf("thursday"), "Thursday", "Wednesday, Thursday, Friday.")
        4 -> Quintuple("How many months are in a year?", "Months in a year?", listOf("12", "twelve"), "Twelve (12) months", "There are 12 months.")
        5 -> Quintuple("What is the first month of the year?", "First month of year?", listOf("january"), "January", "January is the first month.")
        6 -> Quintuple("What is the last month of the year?", "Last month of year?", listOf("december"), "December", "December is the last month.")
        7 -> Quintuple("Which month comes after July?", "Month after July?", listOf("august"), "August", "July, then August.")
        8 -> Quintuple("How many hours are in a day?", "Hours in a day?", listOf("24", "twenty four"), "Twenty-four (24) hours", "There are 24 hours.")
        9 -> Quintuple("How many minutes are in one hour?", "Minutes in an hour?", listOf("60", "sixty"), "Sixty (60) minutes", "There are 60 minutes.")
        10 -> Quintuple("How many seconds are in one minute?", "Seconds in a minute?", listOf("60", "sixty"), "Sixty (60) seconds", "There are 60 seconds.")
        11 -> Quintuple("How many days are in a normal year?", "Days in normal year?", listOf("365"), "365 days", "There are 365 days.")
        12 -> Quintuple("How many days are in a leap year?", "Days in leap year?", listOf("366"), "366 days", "There are 366 days.")
        13 -> Quintuple("Which month has 28 or 29 days?", "Month with 28 or 29 days?", listOf("february"), "February", "February has 28 or 29 days.")
        14 -> Quintuple("Which day comes between Saturday and Monday?", "Day between Saturday and Monday?", listOf("sunday"), "Sunday", "Sunday is the weekend day.")
        15 -> Quintuple("What are the two weekend days?", "Two weekend days?", listOf("saturday and sunday", "saturday", "sunday"), "Saturday and Sunday", "Saturday and Sunday.")
        16 -> Quintuple("How many seasons are traditionally counted in a year?", "Seasons in a year?", listOf("4", "four"), "Four (Spring, Summer, Autumn, Winter)", "There are 4 seasons.")
        17 -> Quintuple("Which is the hottest season of the year?", "Hottest season?", listOf("summer"), "Summer", "Summer is the hot season.")
        18 -> Quintuple("Which season comes after winter?", "Season after winter?", listOf("spring"), "Spring", "Spring brings flowers.")
        19 -> Quintuple("What time of day is 12:00 at night called?", "12:00 at night?", listOf("midnight"), "Midnight", "Midnight.")
        20 -> Quintuple("What time of day is 12:00 in the daytime called?", "12:00 in daytime?", listOf("noon", "midday"), "Noon or Midday", "Noon.")
        else -> Quintuple("How many weeks are in a month roughly?", "Weeks in a month?", listOf("4", "four"), "Four (4) weeks", "About 4 weeks.")
      }

      // Set 5: Animals and Their Young Ones
      5 -> when (qIndex) {
        1 -> Quintuple("What is a baby dog called?", "What is a baby dog called?", listOf("puppy"), "Puppy", "A baby dog is a puppy.")
        2 -> Quintuple("What is a baby cat called?", "What is a baby cat called?", listOf("kitten"), "Kitten", "A baby cat is a kitten.")
        3 -> Quintuple("What is a baby cow called?", "What is a baby cow called?", listOf("calf"), "Calf", "A baby cow is a calf.")
        4 -> Quintuple("What is a baby lion called?", "What is a baby lion called?", listOf("cub"), "Cub", "A baby lion is a cub.")
        5 -> Quintuple("What is a baby hen called?", "What is a baby hen called?", listOf("chick"), "Chick", "A baby hen is a chick.")
        6 -> Quintuple("What is a baby sheep called?", "What is a baby sheep called?", listOf("lamb"), "Lamb", "A baby sheep is a lamb.")
        7 -> Quintuple("What is a baby duck called?", "What is a baby duck called?", listOf("duckling"), "Duckling", "A baby duck is a duckling.")
        8 -> Quintuple("What is a baby horse called?", "What is a baby horse called?", listOf("foal", "colt"), "Foal", "A baby horse is a foal.")
        9 -> Quintuple("What is a baby frog called?", "What is a baby frog called?", listOf("tadpole"), "Tadpole", "A baby frog is a tadpole.")
        10 -> Quintuple("Which animal is known as man's best friend?", "Man's best friend?", listOf("dog"), "Dog", "The dog.")
        11 -> Quintuple("Which bird can swim but cannot fly?", "Bird that swims but cannot fly?", listOf("penguin"), "Penguin", "Penguin lives in cold regions.")
        12 -> Quintuple("Which is the largest land animal?", "Largest land animal?", listOf("elephant"), "Elephant", "The elephant.")
        13 -> Quintuple("Which is the fastest land animal?", "Fastest land animal?", listOf("cheetah"), "Cheetah", "The cheetah runs fast.")
        14 -> Quintuple("Which animal has a very long neck?", "Animal with long neck?", listOf("giraffe"), "Giraffe", "The giraffe.")
        15 -> Quintuple("Which animal gives us wool?", "Animal that gives wool?", listOf("sheep"), "Sheep", "Sheep gives wool.")
        16 -> Quintuple("Where does a bird live?", "Where does a bird live?", listOf("nest"), "Nest", "A bird lives in a nest.")
        17 -> Quintuple("Where does a bee live?", "Where does a bee live?", listOf("beehive", "hive"), "Beehive", "A bee lives in a hive.")
        18 -> Quintuple("Where does a dog sleep?", "Where does a dog sleep?", listOf("kennel"), "Kennel", "A dog sleeps in a kennel.")
        19 -> Quintuple("Which animal is known as the king of the jungle?", "King of the jungle?", listOf("lion"), "Lion", "The lion.")
        20 -> Quintuple("Which insect makes sweet honey?", "Insect that makes honey?", listOf("bee", "honeybee"), "Bee / Honeybee", "The honeybee.")
        else -> Quintuple("What is the sound a dog makes?", "Sound of dog?", listOf("bark", "barking"), "Bark", "A dog barks.")
      }

      // Set 6: Occupations and Professions
      6 -> when (qIndex) {
        1 -> Quintuple("Who treats sick people in a hospital?", "Who treats sick people?", listOf("doctor"), "Doctor", "A doctor.")
        2 -> Quintuple("Who teaches students at school?", "Who teaches students?", listOf("teacher"), "Teacher", "A teacher.")
        3 -> Quintuple("Who flies an airplane?", "Who flies an airplane?", listOf("pilot"), "Pilot", "A pilot.")
        4 -> Quintuple("Who catches criminals and keeps order?", "Who catches criminals?", listOf("policeman", "police officer", "police"), "Police officer", "Police.")
        5 -> Quintuple("Who bakes bread and cakes?", "Who bakes bread?", listOf("baker"), "Baker", "A baker.")
        6 -> Quintuple("Who puts out dangerous fires?", "Who puts out fires?", listOf("firefighter", "fireman"), "Firefighter", "Firefighter.")
        7 -> Quintuple("Who grows crops and vegetables in fields?", "Who grows crops?", listOf("farmer"), "Farmer", "A farmer.")
        8 -> Quintuple("Who treats sick or painful teeth?", "Who treats teeth?", listOf("dentist"), "Dentist", "A dentist.")
        9 -> Quintuple("Who repairs broken cars and vehicles?", "Who repairs cars?", listOf("mechanic"), "Mechanic", "A mechanic.")
        10 -> Quintuple("Who cuts and styles hair?", "Who cuts hair?", listOf("barber", "hairdresser"), "Barber / Hairdresser", "Barber.")
        11 -> Quintuple("Who delivers letters and packages to homes?", "Who delivers letters?", listOf("postman", "mail carrier"), "Postman", "Postman.")
        12 -> Quintuple("Who stitches and sews clothes?", "Who sews clothes?", listOf("tailor"), "Tailor", "A tailor.")
        13 -> Quintuple("Who cooks delicious food in a restaurant?", "Who cooks food?", listOf("chef", "cook"), "Chef / Cook", "A chef.")
        14 -> Quintuple("Who designs houses and buildings?", "Who designs buildings?", listOf("architect"), "Architect", "An architect.")
        15 -> Quintuple("Who paints beautiful pictures?", "Who paints pictures?", listOf("artist", "painter"), "Artist / Painter", "An artist.")
        16 -> Quintuple("Who sings songs on stage?", "Who sings songs?", listOf("singer"), "Singer", "A singer.")
        17 -> Quintuple("Who writes novels and books?", "Who writes books?", listOf("author", "writer"), "Author / Writer", "An author.")
        18 -> Quintuple("Who travels into outer space?", "Who travels to space?", listOf("astronaut"), "Astronaut", "An astronaut.")
        19 -> Quintuple("Who assists the doctor in treating patients?", "Who assists the doctor?", listOf("nurse"), "Nurse", "A nurse.")
        20 -> Quintuple("Who acts in movies and dramas?", "Who acts in movies?", listOf("actor", "actress"), "Actor / Actress", "An actor.")
        else -> Quintuple("Who catches fish in the sea?", "Who catches fish?", listOf("fisherman"), "Fisherman", "A fisherman.")
      }

      // Set 7: Prepositions & Simple Sentences
      7 -> when (qIndex) {
        1 -> Quintuple("The book is ___ the table. (on / in)?", "Book is ___ table?", listOf("on"), "On", "The book is on the table.")
        2 -> Quintuple("The fish swims ___ the water. (in / on)?", "Fish swims ___ water?", listOf("in"), "In", "Fish swims in water.")
        3 -> Quintuple("The cat is sleeping ___ the chair. (under / over)?", "Cat sleeping ___ chair?", listOf("under"), "Under", "Under the chair.")
        4 -> Quintuple("The bird is flying ___ the sky. (in / at)?", "Bird flying ___ sky?", listOf("in"), "In", "In the sky.")
        5 -> Quintuple("We go to school ___ morning. (in the / at)?", "Go to school ___ morning?", listOf("in the", "in"), "In the (morning)", "In the morning.")
        6 -> Quintuple("He wakes up ___ 6:00 AM. (at / in)?", "Wakes up ___ 6:00 AM?", listOf("at"), "At", "At 6:00 AM.")
        7 -> Quintuple("She was born ___ May. (in / on)?", "Born ___ May?", listOf("in"), "In", "In May.")
        8 -> Quintuple("We celebrate Christmas ___ December 25th. (on / at)?", "Christmas ___ Dec 25?", listOf("on"), "On", "On December 25th.")
        9 -> Quintuple("The dog jumped ___ the fence. (over / into)?", "Jumped ___ fence?", listOf("over"), "Over", "Over the fence.")
        10 -> Quintuple("He walked ___ the room. (into / onto)?", "Walked ___ room?", listOf("into"), "Into", "Into the room.")
        11 -> Quintuple("She is sitting ___ her two friends. (between / among)?", "Sitting ___ two friends?", listOf("between"), "Between", "Between two things.")
        12 -> Quintuple("The sun sets ___ the west. (in / on)?", "Sun sets ___ west?", listOf("in"), "In", "In the west.")
        13 -> Quintuple("I agree ___ you. (with / to)?", "Agree ___ you?", listOf("with"), "With", "Agree with you.")
        14 -> Quintuple("She is good ___ English. (at / in)?", "Good ___ English?", listOf("at"), "At", "Good at English.")
        15 -> Quintuple("Listen ___ the teacher. (to / for)?", "Listen ___ teacher?", listOf("to"), "To", "Listen to.")
        16 -> Quintuple("He is afraid ___ dogs. (of / with)?", "Afraid ___ dogs?", listOf("of"), "Of", "Afraid of dogs.")
        17 -> Quintuple("Wait ___ me. (for / to)?", "Wait ___ me?", listOf("for"), "For", "Wait for me.")
        18 -> Quintuple("She looked ___ the mirror. (in / at)?", "Looked ___ mirror?", listOf("in", "into"), "In / into", "In the mirror.")
        19 -> Quintuple("The train arrives ___ the station. (at / on)?", "Train arrives ___ station?", listOf("at"), "At", "At the station.")
        20 -> Quintuple("He came to school ___ bus. (by / in)?", "Came to school ___ bus?", listOf("by"), "By", "By bus.")
        else -> Quintuple("Pen is ___ my pocket. (in / on)?", "Pen is ___ pocket?", listOf("in"), "In", "In my pocket.")
      }

      // Set 8: Colors & Nature
      8 -> when (qIndex) {
        1 -> Quintuple("What color is fresh grass?", "Color of grass?", listOf("green"), "Green", "Fresh grass is green.")
        2 -> Quintuple("What color is the clear sky during the day?", "Color of sky?", listOf("blue"), "Blue", "Sky is blue.")
        3 -> Quintuple("What color is milk?", "Color of milk?", listOf("white"), "White", "Milk is white.")
        4 -> Quintuple("What color is coal or night?", "Color of coal?", listOf("black"), "Black", "Coal is black.")
        5 -> Quintuple("What color is human blood?", "Color of blood?", listOf("red"), "Red", "Blood is red.")
        6 -> Quintuple("What color is a ripe banana?", "Color of ripe banana?", listOf("yellow"), "Yellow", "Ripe banana is yellow.")
        7 -> Quintuple("What color is an orange fruit?", "Color of orange fruit?", listOf("orange"), "Orange", "Orange fruit is orange.")
        8 -> Quintuple("What color do you get by mixing red and white?", "Mixing red and white?", listOf("pink"), "Pink", "Red + white = pink.")
        9 -> Quintuple("What color do you get by mixing blue and yellow?", "Mixing blue and yellow?", listOf("green"), "Green", "Blue + yellow = green.")
        10 -> Quintuple("What color is pure snow?", "Color of snow?", listOf("white"), "White", "Snow is white.")
        11 -> Quintuple("What color is gold metal?", "Color of gold?", listOf("yellow", "gold", "golden"), "Yellow / Golden", "Gold is yellow.")
        12 -> Quintuple("What color is chocolate?", "Color of chocolate?", listOf("brown"), "Brown", "Chocolate is brown.")
        13 -> Quintuple("How many colors are in a rainbow?", "Colors in rainbow?", listOf("7", "seven"), "Seven (7) colors", "There are 7 colors.")
        14 -> Quintuple("What is the first color in a rainbow?", "First color in rainbow?", listOf("red"), "Red", "Red is first (VIBGYOR).")
        15 -> Quintuple("Which planet do we live on?", "Which planet do we live on?", listOf("earth"), "Earth", "Planet Earth.")
        16 -> Quintuple("What gives us light and warmth during daytime?", "What gives light and warmth?", listOf("sun"), "Sun", "The Sun.")
        17 -> Quintuple("What shines in the night sky?", "What shines in night sky?", listOf("moon", "stars"), "Moon / Stars", "The Moon.")
        18 -> Quintuple("What falls from clouds when it rains?", "What falls when it rains?", listOf("water", "rain"), "Water / Rain", "Raindrops.")
        19 -> Quintuple("What large body of saltwater covers most of Earth?", "Body of saltwater?", listOf("ocean", "sea"), "Ocean / Sea", "The Ocean.")
        20 -> Quintuple("What is the highest type of landform?", "Highest landform?", listOf("mountain"), "Mountain", "A mountain.")
        else -> Quintuple("What is a flowing body of freshwater called?", "Flowing freshwater?", listOf("river"), "River", "A river.")
      }

      // Set 9: Synonyms (Words with Similar Meaning)
      9 -> when (qIndex) {
        1 -> Quintuple("What is a word with the same meaning as 'start'?", "Synonym of start?", listOf("begin"), "Begin", "Start and begin.")
        2 -> Quintuple("What is a word with the same meaning as 'shut'?", "Synonym of shut?", listOf("close"), "Close", "Shut and close.")
        3 -> Quintuple("What is a word with the same meaning as 'large'?", "Synonym of large?", listOf("big", "huge"), "Big", "Large and big.")
        4 -> Quintuple("What is a word with the same meaning as 'fast'?", "Synonym of fast?", listOf("quick", "rapid"), "Quick", "Fast and quick.")
        5 -> Quintuple("What is a word with the same meaning as 'smart'?", "Synonym of smart?", listOf("clever", "intelligent"), "Clever", "Smart and clever.")
        6 -> Quintuple("What is a word with the same meaning as 'glad'?", "Synonym of glad?", listOf("happy", "joyful"), "Happy", "Glad and happy.")
        7 -> Quintuple("What is a word with the same meaning as 'simple'?", "Synonym of simple?", listOf("easy"), "Easy", "Simple and easy.")
        8 -> Quintuple("What is a word with the same meaning as 'gift'?", "Synonym of gift?", listOf("present"), "Present", "Gift and present.")
        9 -> Quintuple("What is a word with the same meaning as 'rich'?", "Synonym of rich?", listOf("wealthy"), "Wealthy", "Rich and wealthy.")
        10 -> Quintuple("What is a word with the same meaning as 'help'?", "Synonym of help?", listOf("assist"), "Assist", "Help and assist.")
        11 -> Quintuple("What is a word with the same meaning as 'correct'?", "Synonym of correct?", listOf("right", "true"), "Right", "Correct and right.")
        12 -> Quintuple("What is a word with the same meaning as 'difficult'?", "Synonym of difficult?", listOf("hard"), "Hard", "Difficult and hard.")
        13 -> Quintuple("What is a word with the same meaning as 'quiet'?", "Synonym of quiet?", listOf("silent", "calm"), "Silent", "Quiet and silent.")
        14 -> Quintuple("What is a word with the same meaning as 'look'?", "Synonym of look?", listOf("see", "watch"), "See / Watch", "Look and see.")
        15 -> Quintuple("What is a word with the same meaning as 'speak'?", "Synonym of speak?", listOf("talk", "say"), "Talk", "Speak and talk.")
        16 -> Quintuple("What is a word with the same meaning as 'buy'?", "Synonym of buy?", listOf("purchase"), "Purchase", "Buy and purchase.")
        17 -> Quintuple("What is a word with the same meaning as 'cry'?", "Synonym of cry?", listOf("weep"), "Weep", "Cry and weep.")
        18 -> Quintuple("What is a word with the same meaning as 'beautiful'?", "Synonym of beautiful?", listOf("pretty", "lovely"), "Pretty", "Beautiful and pretty.")
        19 -> Quintuple("What is a word with the same meaning as 'small'?", "Synonym of small?", listOf("tiny", "little"), "Little / Tiny", "Small and little.")
        20 -> Quintuple("What is a word with the same meaning as 'end'?", "Synonym of end?", listOf("finish", "stop"), "Finish", "End and finish.")
        else -> Quintuple("What is a word with same meaning as 'neat'?", "Synonym of neat?", listOf("tidy", "clean"), "Tidy", "Neat and tidy.")
      }

      // Set 10: Everyday Polite English Expressions
      10 -> when (qIndex) {
        1 -> Quintuple("What do you say when someone gives you a gift?", "Say when getting gift?", listOf("thank you", "thanks"), "Thank you", "Say thank you.")
        2 -> Quintuple("What do you say when you hurt or bump into someone?", "Say when hurting someone?", listOf("sorry", "i am sorry"), "I am sorry", "Say sorry.")
        3 -> Quintuple("What do you say when asking someone for help politely?", "Say when asking politely?", listOf("please"), "Please", "Say please.")
        4 -> Quintuple("What greeting do you say in the morning?", "Morning greeting?", listOf("good morning"), "Good morning", "Good morning.")
        5 -> Quintuple("What greeting do you say in the afternoon?", "Afternoon greeting?", listOf("good afternoon"), "Good afternoon", "Good afternoon.")
        6 -> Quintuple("What greeting do you say in the evening?", "Evening greeting?", listOf("good evening"), "Good evening", "Good evening.")
        7 -> Quintuple("What do you say before going to sleep at night?", "Say before sleeping?", listOf("good night"), "Good night", "Good night.")
        8 -> Quintuple("What do you say when someone says 'Thank you' to you?", "Reply to thank you?", listOf("you are welcome", "welcome"), "You are welcome", "You are welcome.")
        9 -> Quintuple("What do you say when leaving someone?", "Say when leaving?", listOf("goodbye", "bye"), "Goodbye / Bye", "Goodbye.")
        10 -> Quintuple("How do you politely ask for someone's name?", "Ask someone's name?", listOf("what is your name", "your name"), "What is your name?", "What is your name?")
        11 -> Quintuple("How do you ask someone how they are feeling?", "Ask how they are?", listOf("how are you", "how do you do"), "How are you?", "How are you?")
        12 -> Quintuple("What is the polite reply to 'How are you'?", "Reply to how are you?", listOf("i am fine", "fine", "fine thank you"), "I am fine, thank you", "I am fine.")
        13 -> Quintuple("What do you say to wish someone on their birthday?", "Birthday wish?", listOf("happy birthday"), "Happy Birthday", "Happy Birthday.")
        14 -> Quintuple("What do you say to congratulate someone who won?", "Congratulate winner?", listOf("congratulations", "well done"), "Congratulations", "Congratulations.")
        15 -> Quintuple("What do you say when sneezing in public?", "Say after sneeze?", listOf("excuse me"), "Excuse me", "Excuse me.")
        16 -> Quintuple("What do you say to someone who sneezes?", "Say to someone sneezing?", listOf("bless you", "god bless you"), "Bless you", "Bless you.")
        17 -> Quintuple("What do you say when you did not hear someone clearly?", "When not hearing clearly?", listOf("pardon", "sorry", "excuse me"), "Pardon me / Excuse me", "Pardon.")
        18 -> Quintuple("What do you say to someone starting an exam or competition?", "Wish before exam?", listOf("good luck", "all the best"), "Good luck / All the best", "Good luck.")
        19 -> Quintuple("What do you say to welcome a guest to your home?", "Welcome a guest?", listOf("welcome"), "Welcome", "Welcome.")
        20 -> Quintuple("What do you say to agree to an invitation happily?", "Agree happily?", listOf("yes please", "sure", "with pleasure"), "Yes, please / With pleasure", "Yes please.")
        else -> Quintuple("What do you say to introduce yourself?", "Introduce yourself?", listOf("my name is", "i am"), "My name is...", "My name is.")
      }
      else -> when (qIndex) {
        1 -> Quintuple("What do you say when greeting someone in the morning?", "Morning greeting?", listOf("good morning"), "Good morning", "Good morning.")
        else -> Quintuple("What do you say to thank someone?", "Thank someone?", listOf("thank you", "thanks"), "Thank you", "Thank you.")
      }
    }
  }

  // ==============================================================================
  // GRADE 11 O/L ENGLISH BANK (100% GRADE 11 SYLLABUS - CLEAR, DIRECT & COMMUNICATIVE)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: Reading comprehension strategies
      1 -> when (qIndex) {
        1 -> Quintuple("What reading skill means reading quickly to get the main general idea?", "Reading quickly for main idea?", listOf("skimming", "skim"), "Skimming", "Skimming is reading for gist.")
        2 -> Quintuple("What reading skill means searching a text quickly for a specific fact or number?", "Searching for specific fact?", listOf("scanning", "scan"), "Scanning", "Scanning is looking for specific details.")
        else -> Quintuple("What do we call the main sentence that states the central idea of a paragraph?", "Sentence stating central idea?", listOf("topic sentence", "topic"), "Topic sentence", "Topic sentence.")
      }

      // Set 2: Formal vocabulary & opposites
      2 -> when (qIndex) {
        1 -> Quintuple("What is a more formal synonym for 'buy'?", "Formal synonym for buy?", listOf("purchase"), "Purchase", "Purchase.")
        2 -> Quintuple("What is a formal synonym for 'start'?", "Formal synonym for start?", listOf("commence", "begin"), "Commence / Begin", "Commence.")
        3 -> Quintuple("What is the antonym (opposite) of 'increase'?", "Opposite of increase?", listOf("decrease", "reduce"), "Decrease / Reduce", "Decrease.")
        else -> Quintuple("What is the opposite of 'permanent'?", "Opposite of permanent?", listOf("temporary"), "Temporary", "Temporary.")
      }

      // Set 3: Active & Passive Voice
      3 -> when (qIndex) {
        1 -> Quintuple("Convert to passive: 'The teacher praised Kamal.'", "Passive of 'Teacher praised Kamal'?", listOf("kamal was praised", "kamal was praised by the teacher"), "Kamal was praised by the teacher.", "Kamal was praised.")
        2 -> Quintuple("Convert to passive: 'They clean the room daily.'", "Passive of 'They clean room daily'?", listOf("the room is cleaned", "room is cleaned"), "The room is cleaned daily.", "The room is cleaned.")
        else -> Quintuple("In passive voice, which preposition is usually used before the agent (the doer)?", "Preposition before agent in passive?", listOf("by"), "By", "By.")
      }

      // Set 4: Reported Speech
      4 -> when (qIndex) {
        1 -> Quintuple("In reported speech, what does the word 'now' change into?", "What does 'now' change into in indirect speech?", listOf("then"), "Then", "Now becomes then.")
        2 -> Quintuple("In reported speech, what does 'today' change into?", "What does 'today' change into?", listOf("that day"), "That day", "Today becomes that day.")
        3 -> Quintuple("In reported speech, what does 'tomorrow' change into?", "What does 'tomorrow' change into?", listOf("the next day", "the following day"), "The next day / The following day", "The next day.")
        else -> Quintuple("In reported speech, what does the present tense 'is' or 'am' change into?", "What does 'is/am' change into?", listOf("was"), "Was", "Was.")
      }

      // Set 5: Relative Clauses
      5 -> when (qIndex) {
        1 -> Quintuple("Which relative pronoun is used to refer to a person: 'who' or 'which'?", "Relative pronoun for person?", listOf("who"), "Who", "Who is for people.")
        2 -> Quintuple("Which relative pronoun is used to refer to an inanimate thing: 'who' or 'which'?", "Relative pronoun for things?", listOf("which", "that"), "Which / That", "Which is for things.")
        3 -> Quintuple("Which relative pronoun is used to refer to a place?", "Relative pronoun for place?", listOf("where"), "Where", "Where is for places.")
        else -> Quintuple("Which relative pronoun indicates possession or belonging?", "Relative pronoun for possession?", listOf("whose"), "Whose", "Whose.")
      }

      // Set 6: Conditional Sentences
      6 -> when (qIndex) {
        1 -> Quintuple("Complete the conditional: 'If it rains tomorrow, we _____ stay at home.' (will / would)", "Complete: If it rains, we _____ stay.", listOf("will"), "will (will stay)", "Type 1 conditional uses 'will'.")
        2 -> Quintuple("Complete: 'If I won a lottery, I _____ travel the world.' (will / would)", "Complete: If I won, I _____ travel.", listOf("would"), "would", "Type 2 conditional uses 'would'.")
        else -> Quintuple("What conjunction means 'if not' in conditional sentences?", "Conjunction meaning 'if not'?", listOf("unless"), "Unless", "Unless means if not.")
      }

      // Set 7: Formal Letters & Emails
      7 -> when (qIndex) {
        1 -> Quintuple("When a formal letter begins with 'Dear Sir', how should you close it?", "Closing when starting with Dear Sir?", listOf("yours faithfully"), "Yours faithfully", "Yours faithfully.")
        2 -> Quintuple("When a formal letter begins with the recipient's name like 'Dear Mr. Silva', how should you close it?", "Closing when starting with Dear Mr. Silva?", listOf("yours sincerely"), "Yours sincerely", "Yours sincerely.")
        else -> Quintuple("What part of a formal letter summarizes the topic in one line?", "One-line summary in formal letter?", listOf("subject", "heading"), "Subject (Re:)", "Subject line.")
      }

      // Set 8: Linking Words
      8 -> when (qIndex) {
        1 -> Quintuple("Which conjunction expresses a contrast: 'although' or 'because'?", "Conjunction expressing contrast?", listOf("although", "however"), "Although / However", "Although shows contrast.")
        2 -> Quintuple("Which conjunction shows a cause or reason: 'because' or 'therefore'?", "Conjunction expressing cause?", listOf("because", "since", "as"), "Because", "Because gives reason.")
        else -> Quintuple("Which linker shows a result or consequence: 'therefore' or 'furthermore'?", "Linker showing result?", listOf("therefore", "so", "consequently"), "Therefore", "Therefore shows result.")
      }

      // Set 9: Idioms & Expressions
      9 -> when (qIndex) {
        1 -> Quintuple("What does the idiom 'a piece of cake' mean?", "Meaning of 'a piece of cake'?", listOf("very easy", "easy"), "Very easy", "Something very easy.")
        2 -> Quintuple("What does the idiom 'break a leg' mean when wishing an actor?", "Meaning of 'break a leg'?", listOf("good luck"), "Good luck", "Good luck.")
        else -> Quintuple("What does 'once in a blue moon' mean?", "Meaning of 'once in a blue moon'?", listOf("very rarely", "rarely"), "Very rarely", "Rarely happens.")
      }

      // Set 10: Phrasal Verbs
      else -> when (qIndex) {
        1 -> Quintuple("What does the phrasal verb 'give up' mean?", "Meaning of 'give up'?", listOf("stop trying", "surrender", "quit"), "Stop trying / Surrender", "Stop trying.")
        2 -> Quintuple("What does 'look after' mean?", "Meaning of 'look after'?", listOf("take care of", "care for"), "Take care of", "Take care of.")
        3 -> Quintuple("What does 'put off' mean regarding a meeting?", "Meaning of 'put off' meeting?", listOf("postpone", "delay"), "Postpone / Delay", "Postpone.")
        else -> Quintuple("What does 'call off' mean regarding an event?", "Meaning of 'call off' event?", listOf("cancel"), "Cancel", "Cancel.")
      }
    }
  }
}

