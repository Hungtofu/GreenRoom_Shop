drop database green_room;
create database green_room;
use green_room;	

create table roles(
	id int auto_increment,
    role_name varchar(255),
    created_date timestamp default current_timestamp,

    primary key(id)
);

create table users(
	id int auto_increment,
    email varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    phone_numbers varchar(10),
    address varchar(255),
	role_id int,
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table types_plant(
	id int auto_increment,
    type_name varchar(255),
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table plants(
	id int auto_increment,
    display_name varchar(255),
    botanical_name varchar(255),
    common_name varchar(255),
    descr text,
    is_rare boolean,
    type_plant int,
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table sizes(
	id int auto_increment,
    size_name varchar(255),
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table pot_types(
	id int auto_increment,
    pot_type_name varchar(255),
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table products(
	id int auto_increment,
    plant_id int,
    size_id int,
    pot_type_id int,
    price decimal(12,2),
    stock int,
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table images(
	id int auto_increment,
    plant_id int,
    url text,
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table carts(
	id int auto_increment,
    user_id int,
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table cart_items(
	id int auto_increment,
    cart_id int,
    product_id int,
    quantity int,
    
    primary key (id)
);

create table orders(
	id int auto_increment,
    user_id int,
    status varchar(255),
    total decimal(15,2),
    created_date timestamp default current_timestamp,
    
    primary key (id)
);

create table order_items(
	id int auto_increment,
    order_id int,
    product_id int,
    quantity int,
    price decimal(12,2),
    
    primary key (id)
);

alter table users add constraint fk_users_roles_role_id foreign key (role_id) references roles(id);
alter table plants add constraint fk_plants_types_plant_type_plant foreign key (type_plant) references types_plant(id);
alter table products add constraint fk_products_plants_plant_id foreign key (plant_id) references plants(id);
alter table products add constraint fk_products_sizes_size_id foreign key (size_id) references sizes(id);
alter table products add constraint fk_products_pot_types_pot_type_id foreign key (pot_type_id) references pot_types(id);
alter table images add constraint fk_images_plants_plant_id foreign key (plant_id) references plants(id);
alter table carts add constraint fk_carts_users_user_id foreign key (user_id) references users(id);
alter table cart_items add constraint fk_cart_items_carts_cart_id foreign key (cart_id) references carts(id);
alter table cart_items add constraint fk_cart_items_products_product_id foreign key (product_id) references products(id);
alter table orders add constraint fk_orders_users_user_id foreign key (user_id) references users(id);
alter table order_items add constraint fk_order_items_orders_order_id foreign key (order_id) references orders(id);
alter table order_items add constraint fk_order_items_products_product_id foreign key (product_id) references products(id);	

use green_room;

-- insert values for roles
insert into roles (role_name) values ('ADMIN');
insert into roles (role_name) values ('MANAGER');
insert into roles (role_name) values ('CUSTOMER');

-- insert valeus for users
insert into users (email, username, password, role_id) values ('admin1@gmail.com', 'admin1', '$2a$12$d2tLRwUgBhCpMu10I3c7.e/IQ3joNGj0RqcylGnuxlr3RQuOkVyGC', 1);
insert into users (email, username, password, role_id) values ('manager1@gmail.com', 'manager1', '$2a$12$d2tLRwUgBhCpMu10I3c7.e/IQ3joNGj0RqcylGnuxlr3RQuOkVyGC', 2);
insert into users (email, username, password, role_id) values ('customer1@gmail.com', 'cuatomer1', '$2a$12$d2tLRwUgBhCpMu10I3c7.e/IQ3joNGj0RqcylGnuxlr3RQuOkVyGC', 3);

-- insert values for sizes
insert into sizes(size_name) values('2" Pot');
insert into sizes(size_name) values('3" Pot');
insert into sizes(size_name) values('4" Pot');
insert into sizes(size_name) values('6" Pot');
insert into sizes(size_name) values('8" Pot');
insert into sizes(size_name) values('10" Pot');

-- insert values for typy plants
insert into types_plant(type_name) values('Flowering plants');
insert into types_plant(type_name) values('Trailing & Vining plants');
insert into types_plant(type_name) values('Succulents & Cacti');
insert into types_plant(type_name) values('Aquatic plants');
insert into types_plant(type_name) values('Outdoor plants');
insert into types_plant(type_name) values('Dried plants');

-- insert values for pot types
insert into pot_types(pot_type_name) values('Nursery Pot');
insert into pot_types(pot_type_name) values('Black Cylinder');
insert into pot_types(pot_type_name) values('White Cylinder');
insert into pot_types(pot_type_name) values('Terra Cotta');

-- insert values for flowering plant (typePlant=1)  
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Blue Hydrangea', null, null, 'Hardy and long-lasting, with blooms that burst in brilliant blue. Will arrive blooming.\nThe small bush blooms in early summer, then re-blooms again late summer or early fall if planted outside. The sturdy stems ensure the flowers are help upright, and make the blooms perfect for cut flower arrangements and indoor decoration.\n4\" - Comes with 1 Blooming Head\n6\" - Comes with 3 Blooming Head', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Pink Hydrangea', null, null, 'Hardy and long-lasting, with blooms that burst in pink. Will arrive blooming.\nThe small bush blooms in early summer, then re-blooms again late summer or early fall if planted outside. The sturdy stems ensure the flowers are help upright, and make the blooms perfect for cut flower arrangements and indoor decoration.\n4\" - Comes with 1 Blooming Head\n6\" - Comes with 3 Blooming Heada', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('White Hydrangea', null, null, 'Hardy and long-lasting, with blooms that burst in white. Will arrive blooming.\nThe small bush blooms in early summer, then re-blooms again late summer or early fall if planted outside. The sturdy stems ensure the flowers are help upright, and make the blooms perfect for cut flower arrangements and indoor decoration.\n4\" - Comes with 1 Blooming Head\n6\" - Comes with 3 Blooming Head', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Gardenia \'Bush\'', 'Gardenia jasminoides', 'Gardenia', 'Known for its beautiful foliage and intoxicating fragrance, it’s easy to understand why so many are tempted to add this stunning specimen to the home landscape. However, these popular evergreen shrubs are known for their finicky needs. In fact, in some areas, gardenias require considerable maintenance.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Begonia \'Striped\'', 'Begonia listada', 'Bedding Begonia', 'Begonia \'Striped\', is a flowering shrub-like plant native to Brazil. It has compact growth, velvet leaves, and a bright green stripe down the center of each leaf. The underside of the leaves is a rich mahogany color. The plant also has white flowers', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Calla Lily', 'Zantedeschia', 'Calla Lily', 'You can also grow calla lilies in containers, either outdoors or in a sunny window as houseplants.This beautiful plant, available in a multitude of colors, grows from rhizomes and is an ideal plant to add to your garden or as a indoor house plant.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Kalanchoe', 'Kalanchoe blossfeldiana', 'Flaming Katy', 'Kalanchoe blossfeldiana, commonly called kalanchoe, is a dark green, succulent perennial with scallop-edged leaves and large umbels of flower clusters held above the foliage. It has an upright, multi-branched growth habit. These bright red, pink or yellow flower clusters last for weeks.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Orchid \'White Phalaenopsis\'', 'Phalaenopsis amabilis', 'Moon Orchid, Moth Orchid, The Lovely Phalaenopsis', 'Phalaenopsis, sometimes referred to as moth orchids, is a genus of roughly 70 plant species in the Orchidaceae family. With long, coarse roots, short, leafy stems, and long-lasting, flat blooms organized in a flowering stem that frequently branches at the end, orchids in this genus are monopodial epiphytes or lithophytes.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Orchid \'Yellow Phalaenopsis\'', 'Phalaenopsis amabilis', 'Moon Orchid, Moth Orchid, The Lovely Phalaenopsis', 'Phalaenopsis, sometimes referred to as moth orchids, is a genus of roughly 70 plant species in the Orchidaceae family. With long, coarse roots, short, leafy stems, and long-lasting, flat blooms organized in a flowering stem that frequently branches at the end, orchids in this genus are monopodial epiphytes or lithophytes.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Dipladenia Premier Hot Pink', 'Dipladenia ', 'mandevilla', 'Great option for full sun gardens! Mounding habit allows options for both in-ground planting and container gardening… with bold tropical flowers!', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Sedum Little Miss Sunshine', 'Sedum kamtschaticum', 'Stonecrop', '\'Little Miss Sunshine\' is prized for its incredibly dark green, glossy foliage, compact size, and tidiness in the landscape. From early to midsummer, tiny clusters of yellow flowers cover the polished habit. This perennial is tough and drought tolerant once established, so it\'s perfect for areas with hot, dry summers.', 0, 1);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Begonia \'Frosty\'', 'Begonia \'Don Miller\'', 'Frost, Frosty', '\'Frosty\' is a bushy begonia that is erect with succulent stems. The many everblooming flowers are single and white in color. The bronze leaves are shiny, smooth and ovate. This plant can tolerate full sun. Soil should ideally be moist. Begonias grow very well in peat-based compost also. Likes humidity. Does not like cold weather. Pinching tips and pruning outer stems in the growing season gives a bushier plant, good for hanging baskets. Remove dead foliage to prevent disease.', 0, 1);

-- insert values for Trailing & Vining plants (typePlant=2)  
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Monstera \'Split-Leaf\'', 'Philodendron Monstera deliciosa', 'Swiss Cheese or Hurricane Plant, Fruit Salad Plant , Monstera', 'Native to the tropical forests of Central and South America, these plants have glossy, heart shaped leaves which develops its unique splits in its maturity. It is a climbing, evergreen perennial vine that is perhaps most noted for its large perforated leaves on thick plant stems and its long cord-like aerial roots.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Monstera Adansonii \'Swiss Cheese\'', 'Monstera adansonii', 'Adanson\'s monstera, Swiss cheese vine, five holes plant', 'The Swiss Cheese plant, gets its name from its large, heart-shaped leaves, which become covered with holes that resemble swiss cheese as it gets older. Part of the Araceae family that\'s native to South and Central America, this Monstera is easy to grow and loves to climb and grow upwards.', 1, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Philodendron Cordatum \'Heartleaf\'', 'Philodendron hederaceum', 'Cordatum heartleaf', 'This common epyphytic houseplant is native to coastal Brazil and grows in a vinelike or climbing fashion. It wields heart-shaped leaves and is a great addition to any office or household as it is very easy to care for, requiring minimal waterings and only needing low to medium indirect sunlight', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Spider Plant \'Bonnie\'', 'Chlorophytum comosum', 'spider plant, airplane plant, spider ivy', 'The Spider plant is a flowering perennial native tropical South Africa. The leaves of the spider plant are thin ribbon like strands which end in a point and grow upward and bend downward giving it the look of a spider. The Spider plant produces small white flowers that grow along a long stalk independent to the leaves of the spider plant. Also known for their air purifying qualities, the spider plant is a great companion to any household of office.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Pothos \'Satin\'', 'Scindapsus pictus \'Argyraeus\'', 'Pothos, Satin, Pothos Pictus, Silver Vine', 'This striking tropical plant is fairly new to house plant nurseries, and is garnering a lot of attention. Big, heart-shaped leaves are dark-green and splashed with silvery gray, giving them a satin sheen. Its compact growth habit makes Scindapsus pictus \'Argyraeus\' a beautiful hanging basket plant. You\'ll see the best leaf color and variegation by keeping it in bright, indirect light. You\'ll also keep the plant healthy by boosting the humidity around it. In fact, its variegated foliage makes Satin Pothos a beautiful addition to a terrarium.', 1, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Philodendron \'Brasil\'', 'Philodendron cordatum', 'Cordatum Brasil', 'This common epyphytic houseplant is native to coastal Brazil and grows in a vinelike or climbing fashion. It wields heartshaped leaves and is a great addition to any office or household as it is very easy to care for, requiring minimal waterings and only needing low to medium indirect sunlight. This particular, "Brasil" variety, will have segment on each leaf seperating its yellow and green color.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Maranta \'Red Prayer\'', 'Maranta', 'Prayer plant', 'The Maranta is a evergreen perennial native to Central and South America. This plant flat oval leaves with a line pattern that runs symmetrically across the leaves.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Pothos \'Neon\'', 'Epipremnum pinnatum', 'Neon Pothos', 'An electrifying color variation on the standard Pothos. ‘Neon’ has all of the tough, reliable features houseplant lovers have come to expect from Pothos, but with glowing, neon-green foliage. Place where the vines can fall freely or trail along a shelf for the best effect. Looks great grown in containers and hanging baskets. A terrific plant for tall plant stands where the trailing foliage will create a cascade of foliage over time.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Scindapsus Pictus \'Exotica\'', 'Scindapsus pictus \'Exotica\'', ' Large-Leaf Pothos Picta, Silver Pothos, Exotica', 'This plant is very similar to Scindapsus pictus var. \'Argyreus\' but where Argyreus has more defined spots and edge markings, this plant has a wider area of silver splashing across the leaf that is less defined. Holding it under a light, the silver on some leaves appear to shimmer and take on a satin look. Scindapsus pictus is a slower growing vine that is a member of the Araceae family and native to Thailand and the Philippines. Not as common of a houseplant as Pothos, but it does well in normal household environments but will appreciate higher humidity. This species features rounded-heart-shaped leaves that curve to one side at the tip. In time, it can easily grow to lengths of several feet long. For best color, keep in bright, indirect light but it will also do well in shady areas.', 1, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Pothos \'Marble Queen\'', 'Epipremnum aureum \'Marble Queen\'', 'Marble Queen Pothos, ', 'This Pothos is a variegated version with more white than green. It is so easy, perfect for beginners, as pothos is one of the easiest plants to grow. This plant is so easy going. You can grow it in a hanging basket, let it climb or even grow horizontally along a tabletop or mantle. This plant will tolerate any light condition, though it\'s preference is moist soil and medium to high light spots. It even forgives for the occasional missed watering! No need to fertilize very often, maybe twice per year.', 1, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Maranta \'Lemon Lime\'', 'Maranta', 'Prayer plant', 'The Maranta is a evergreen perennial native to Central and South America. This plant flat oval leaves with a line pattern that runs symmetrically across the leaves. ', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('English Ivy \'Green California\'', 'Hedera helix \'Green California\'', 'English Ivy, Common Ivy', 'Attractive, deep green colored foliage with no variegation. One of the best choices for a fast-growing arrangement or ground cover. Easy to grow vining plant that grows fairly quickly.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Philodendron \'Velvet\'', 'Philodendron micans', 'Velvet Philodendron, Philodendron Micans, Heart-Leaf, Sweetheart Plant', 'Philodendron micans is also known by the names Heart-Leaf Philodendron and Sweetheart Plant. This species originates from Central America and parts of the Caribbean and is a commonly grown houseplant in many places, including the UK. This type of philodendron plant has velvet-textured heart-shaped leaves that are greenish bronze with reddish brown undersides. It produces long vining stems.', 1, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Hoya Carnosa \'Tricolor\'', 'Hoya carnosa \'tricolor\'', 'Tricolor, Porcelain Flower, Wax Plant, Honey Plant', 'Remind yourself how spectacular you are by surrounding yourself with the beautiful, leafy vines of a Hoya Tricolor. The indoor vines of this plant love to change color according to how much light they receive. Turning pink is this houseplant’s way of showing you how well you are caring for it. The brighter the indirect light, the more pink variegation these plants may produce. Just remember to keep them away from direct sunlight.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Pothos \'Green Queen\'', 'Epipremnum Aureum', 'Devil\'s Ivy', 'This Air purifying plant is arguably one of the easiest plants to grow indoors. The pothos grows in a vine like fashion making it a great plant to have in a hanging display to fill up any empty space on a shelf or desktop.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Syngonium \'Strawberry\'', 'Syngonium podophyllum \'Strawberry\'', 'Goosefoot Plant, nephthytis, elephant ear plants, Arrowhead Plant', 'Is an evergreen perennial native to Central and South America. This plant grows large, thin, heart shaped leaves which come in a variety of vibrant colors. This particular variety is a bright pinkish-red with a green underside, the color difference can form a gradient on the leaves.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('English Ivy \'Glacier\'', 'Hedera helix \'Glacier\'', 'English Ivy, Common Ivy', ' Foliage bears a rich, emerald green coloring with high contrast, creamy white margins. A fast growing vine that roots as it travels, or climbs with clinging rootlets onto any vertical surface. One of the best choices for a fast-growing arrangement or ground cover.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Syngonium \'White Butterfly\'', 'Syngonium podophyllum', 'Goosefoot Plant, nephthytis, elephant ear plants', 'Is an evergreen perennial native to Central and South America. This plant grows large, thin, heart shaped leaves which come in a variety of vibrant colors. This particular variety\'s leaves are a washed out bright green to light grey with a green underside.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Hoya \'Rope Plant\' Variegated', 'Hoya Hindu Rope Variegated', 'Hindu Rope, Porcelain Flower, Wax Plant, Honey Plant, Krinkle Curl', 'Unique Hindu rope plants, Hoya carnosa compacta, are draping succulent vines that produce clusters of star-shaped waxy flowers. The thick, twisted, curly, cupped leaves of a Hindu rope plant are why it’s often called Krinkle Kurl. Hindu rope plants can be found in solid green or with variegated leaves. This type of hoya plant is very easy to care for as long as you have plenty of light and are careful with your water.', 0, 2);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Peperomia \'Hope\'', 'Peperomia tetraphylla \'Hope\'', 'Hope', 'Peperomia Hope is a lovely hybrid cultivar belonging to the wide and varied genus of popular houseplants, Peperomia. It is a cross between Peperomia deppeana and Peperomia quadrifolia, both of which are low growing vining epiphytes with small green round leaves on thin stems.', 0, 2);

-- insert values for Succulents & Cacti (typePlant=3)  
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'Ripple Jade\'', 'Crassula arborescens undulatifolia', 'Ripple jade, Curly Jade', 'The ripple jade is a succulent native to South Africa. This small succulent grow in a shrub or cluster with stout branches and wavy, dense leaves which are bluish-grey green in color. This is a great, unique addition to any succulent collection. ', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Crassula \'Jade\'', 'Crassula ovata', 'Jade succulent, Money Plant', 'The crassula ovata is an evergreen succulent native to South Africa. It has fascinating green finger-like leaves with a red circle on the tips and can produce small pinkish-white star-shaped flowers during late fall and early winter.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'String of Bananas\'', 'Senecio radicans', 'string of bananas', 'The string of bananas is a trailing succulent native to South Africa. This plant has long, loose tendrils with small and thick banana shaped foliage which retains the plants\' water.', 1, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Senecio Succulent \'Fish Hooks\'', 'Senecio radicans', 'Fish Hooks', 'The Senecio Fish hooks is a trailing succulent which has curved, tube like foliage which grows along the vines of this plant. The color of the foliage can be anywhere from a washed out green to a greenish blue.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'Elephant Bush\'', 'Portulacaria Afra', 'Elephant Bush', 'The elephant bush is a common succulent native to South Africa. Cultivated as an ornamental plant, this plant is a great choice for any beginner succulent collector as it is very low maintenance and its dense bright green leaves are an essential look. The elephant bush has small, round pad-like leaves with thick reddish brown stems and can grow as a tree or a small shrub depending on your planting preferences.  ', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Senecio Stapeliiformis \'Pickle Plant\'', 'Senecio Stapeliiformis', 'Pickle Plant', 'The pickle plant is a succulent perennial native to South Africa. This flowering succulent wields segmented pencil like stems which can grow up to 10 inches tall, giving it the appearance of a very skinny cactus as there are soft spines along its stalks.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Portulacaria \'Rainbow Bush\'', 'Portulacaria', 'Rainbow Bush', 'The rainbow bush is a common succulent native to South Africa. Cultivated as an ornamental plant, this plant is a great choice for any beginner succulent collector as it is very low maintenance and its dense bright green leaves are an essential look. The elephant bush has small, round pad-like leaves with thick reddish brown stems and can grow as a tree or a small shrub depending on your planting preferences.  ', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'String of Pearls\'', 'Senecio rowleyanus', 'String of Pearls', 'The string of pearls is a trailing succulent native to South Africa. This plant has long, loose tendrils with pearl shaped foliage which retains the plants\' water.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Delosperma echinatum \'Pickle Plant\'', 'Delosperma echinatum', 'Pickle Plant', 'The lovely thing about Delosperma echinatum is that it has succulent leaves that are surrounded by bristly hairs. At first glance, you’ll be afraid to touch those hairs as it looks like they’re going to hurt. But thankfully, those spine-like white hairs are soft. Be ready to add this unique plant to your collection.', 1, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Zebra Succulent', 'Haworthia fasciata', 'Zebra succulent', 'This remarkable succulent, characterized by its strikingly striped, zebra-like leaves, is a true natural wonder. Its compact size makes it perfect for both indoor and outdoor settings, and its low-maintenance nature makes it an ideal choice for beginners and seasoned gardeners alike. The Haworthia Zebra thrives in bright, indirect sunlight and well-draining soil, making it easy to care for. Its unique, architectural appearance adds an artistic touch to any space, whether you place it on a sunny windowsill, in a terrarium, or as part of a succulent garden. With its timeless beauty and enduring charm, the Haworthia Zebra Succulent is sure to be a conversation starter and a cherished addition to your greenery collection.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('String of Hearts Variegated', 'Ceropegia woodii', 'String of Hearts Variegated', 'The string of hearts is a trailing succulent native to South Africa. This plant has long, loose tendrils with circular, spade shaped leaves which gives it the appearance of small hearts growing along its vines. The plants foliage has a blotched pattern which can range from pink to light green, giving it a very unique camo-like look. ', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Fairy Castle Cactus', 'Acanthocereus Tetragonus', 'Fairy Castle Cactus', 'The cactus plant also originates in popular regions of Mexico, the Caribbean, Central America, and northern South America. The spiky plant shares resemblance with the turrets of a castle due to its curvy, columnar shape. This is the reason why it is popularly known as a fairy castle cactus.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Euphorbia \'Trigona Rubra\'', 'Euphorbia lactea', 'African Milk Tree, Good Luck Plant', 'Euphorbia \'Trigona Rubra\' is also known as "Royal Red". An attractive cultivar of Euphorbia Trigona with stems and leaves flushed red to magenta. The leaves can be magenta while the stems are green.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent Adenium Obesum \'Desert Rose\'', 'Adenium Obesum', 'Desert Rose', 'Adenium obesum is a poisonous species of flowering plant belonging to tribe Nerieae of subfamily Apocynoideae of the dogbane family, Apocynaceae, that is native to the Sahel regions, south of the Sahara, and tropical and subtropical eastern and southern Africa and Arabia.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Lifesaver Cactus', 'Huernia zebrina', 'Lifesaver Cactus', 'Plant enthusiasts worldwide grow Huernias indoors because of their interesting stem shapes and colors. Lifesaver plants can be grown as intriguing indoor, greenhouse or summer patio container plants almost anywhere. Huernias require a potting mix with excellent drainage.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Rat Tail Cactus', 'Disocactus flagelliformis', 'Rat Tail Cactus', 'The rattail cactus, is a species of flowering plant in the cactus family Cactaceae, and is the most cultivated species in the genus Aporocactus. Due to its ease of cultivation and attractive floral displays, it is often grown as an ornamental potted plant.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Euphorbia \'Sausage Spurge\'', 'Euphorbia Guentheri', 'Sausage Spurge', 'A stout perennial succulent herb with long, cylindrical stems, with prominent spine-tipped tubercles and fleshy sickle-shaped deciduous leaves. Flowers small with a red rim-like gland and enclosed in two fused greenish-white bracts with lovely purple mottling. At yet very few species of this Genus are to be found in collections but this one is one of the older species described during the early part of the twentieth-century Euphorbia succulent varieties are easy to grow and are suited to any well drained soil in full sun. They grow well when there is a layer of brick and charcoal pieces, on top of which sandy loam soil is spread. They need little maintenance. Young plant are happy growing indoors.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Cereus forbesii \'Spiralis\'', 'Cereus forbesii \'Spiralis\'', 'Spiral Cactus', 'Step into the captivating world of the spiral cactus, scientifically known as Cereus forbesii ‘spiralis,’ a botanical treasure from Peru. While growing in popularity, the spiral cactus remains more elusive than its common counterparts. Once mature, this striking cactus can soar to heights of 6 to 13 feet, boasting a diameter of 4 to 5 inches, and is one of the fastest-growing cactus varieties, rewarding caretakers with swift growth.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Aloe Vera', 'Aloe Barbadensis Mill', 'Chinese Aloe, First Aid Plant, Burn Aloe, True Aloe.', 'The Aloe Vera is a stemless succulent with thick and fleshy leaves that are lined with small teeth making it a great ornamental, low maintenance indoor plant which blooms a yellow tubular flower in the summertime. Native to the Arabian Peninsula, this plant is widely used around the world as its leaves are considered to be antimicrobial and has been used to treat burns as a topical medication.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'String of Dolphins\'', 'Senecio peregrinus', 'string of dolphins', 'The string of dolphins is a trailing succulent native to South Africa. This plant has long, loose tendrils with small and thick dolphin shaped foliage which retains the plants\' water.', 0, 3);
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Succulent \'String of Hearts\'', 'Ceropegia woodii', 'String of Hearts ', 'The string of hearts is a trailing succulent native to South Africa. This plant has long, loose tendrils with circular, spade shaped leaves which gives it the appearance of small hearts growing along its vines. The plants foliage has a blotched pattern which can range from pink to light green, giving it a very unique camo-like look. ', 0, 3);

-- insert values for Aquatic plants (typePlant=4)  

-- insert values for Outdoor plants (typePlant=5)  
insert into plants(display_name, botanical_name, common_name, descr, is_rare, type_plant) values ('Noble Fir Tree', 'Latin Abies nobilis', 'Noble Fir Tree, Christmas Tree', 'The noble fir is a popular choice for Christmas trees. Distinct branches with open spaces, allow you to showcase ornaments while avoiding the appearance of bare spots. Noble firs show attractive, smooth, silvery-gray bark with one inch gray-green or bright blue-gray leaves. Native in western Oregon, Washington, and northwest California.', 0, 5);

-- insert values for Dried plants (typePlant=6)  


-- insert values for products
insert into products(plant_id, size_id, pot_type_id, price, stock) values(1, 3, null, 22.99, 20);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(1, 4, null, 44.99, 20);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(2, 3, null, 22.99, 20);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(3, 3, null, 22.99, 20);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(4, 3, null, 26.99, 20);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(4, 4, null, 36.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(5, 3, null, 26.99, 20);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(6, 3, null, 19.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(6, 4, null, 39.99, 2);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(7, 3, null, 24.99, 10);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(7, 4, null, 39.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(8, 3, null, 39.99, 10);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(8, 4, null, 59.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(9, 3, null, 29.99, 10);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(9, 4, null, 49.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(10, null, null, 24.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(11, null, null, 22.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(12, 3, null, 23.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 1, 1, 14.99, 3);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 3, 1, 19.99, 2);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 3, 2, 42.99, 1);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 3, 3, 42.99, 5);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 3, 4, 42.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 4, 1, 29.99, 10);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 4, 2, 52.99, 5);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 4, 3, 52.99, 7);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 5, 1, 49.99, 3);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(13, 6, 1, 139.99, 2);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 1, 1, 23.99, 18);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 2, 1, 13.99, 2);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 3, 1, 20.99, 106);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 3, 2, 39.99, 60);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 3, 3, 39.99, 12);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 3, 4, 39.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 4, 1, 34.99, 90);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 4, 2, 59.99, 81);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 4, 3, 59.99, 90);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(14, 5, 1, 74.99, 7);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 2, 1, 13.99, 101);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 3, 1, 19.99, 132);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 3, 2, 42.99, 111);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 3, 3, 42.99, 63);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 3, 4, 42.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(15, 4, 1, 39.99, 53);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 3, 1, 24.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 4, 1, 39.99, 33);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 5, 1, 51.99, 19);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 5, 2, 75.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 5, 3, 75.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(16, 5, 4, 75.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 2, 1, 14.99, 135);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 3, 1, 24.99, 114);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 3, 2, 39.99, 108);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 3, 3, 39.99, 60);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 3, 4, 39.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 4, 1, 34.99, 66);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 4, 2, 59.99, 66);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(17, 4, 3, 59.99, 66);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(18, 2, null, 13.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(18, 3, null, 19.99, 140);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(18, 4, null, 39.99, 86);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(18, 5, null, 53.99, 34);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(19, 2, null, 13.99, 63);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(19, 3, null, 22.99, 170);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(19, 4, null, 39.99, 33);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(19, 5, null, 53.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(20, 2, null, 13.99, 89);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(20, 3, null, 21.99, 138);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(20, 4, null, 39.99, 47);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(20, 5, null, 53.99, 17);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(21, 3, null, 20.99, 154);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(21, 4, null, 44.99, 34);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(21, 5, null, 74.99, 19);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(22, 2, null, 12.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(22, 3, null, 24.99, 146);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(22, 4, null, 34.99, 96);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(22, 5, null, 60.99, 17);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(23, 3, null, 19.99, 188);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(23, 4, null, 39.99, 48);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(24, 2, 1, 13.99, 112);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(24, 3, 1, 19.99, 54);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(24, 3, 2, 42.99, 54);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(24, 4, 1, 36.99, 65);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 2, 1, 13.99, 111);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 3, 1, 24.99, 106);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 3, 2, 40.99, 105);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 3, 3, 40.99, 57);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 3, 4, 40.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 4, 1, 39.99, 53);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 4, 2, 64.99, 53);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 4, 3, 64.99, 53);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(25, 5, 1, 61.99, 9);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(26, 2, null, 13.99, 80);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(26, 3, null, 29.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(26, 4, null, 39.99, 25);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(27, 3, null, 19.99, 52);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(27, 4, null, 36.99, 24);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(28, 2, null, 14.99, 56);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(28, 3, null, 19.99, 182);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(28, 4, null, 39.99, 54);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 2, 1, 13.99, 68);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 3, 1, 19.99, 171);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 3, 2, 42.99, 135);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 3, 3, 42.99, 76);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 3, 4, 42.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(29, 4, 1, 36.99, 24);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(30, 2, null, 14.99, 21);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(30, 3, null, 19.99, 118);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(30, 4, null, 39.99, 22);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(31, 2, null, 19.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(31, 3, null, 29.99, 136);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(31, 4, null, 44.99, 29);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(31, 5, null, 56.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(32, 2, null, 9.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(32, 3, null, 13.99, 25);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(32, 4, null, 39.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(32, 5, null, 69.99, 4);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(33, 3, null, 19.99, 32);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(34, 3, null, 13.99, 46);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(34, 4, null, 19.99, 218);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(35, 3, null, 22.99, 44);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(35, 4, null, 39.99, 18);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(36, 3, 1, 22.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(36, 3, 2, 39.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(36, 4, 1, 39.99, 7);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(36, 4, 2, 58.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(37, 3, null, 19.99, 141);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(37, 4, null, 39.99, 12);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(37, 5, null, 59.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(38, 3, null, 19.99, 56);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(38, 4, null, 39.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(39, 3, null, 19.99, 30);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 2, 1, 13.99,0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 3, 1, 22.99, 157);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 3, 2, 45.99, 95);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 3, 3, 45.99, 76);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 3, 4, 45.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 4, 1, 39.99, 42);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 4, 2, 62.99, 42);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 4, 3, 62.99, 42);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(40, 4, 4, 62.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(41, 2, null, 14.99, 46);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(41, 3, null, 24.99, 23);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(41, 4, null, 39.99, 13);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(42, 2, null, 14.99, 117);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(42, 3, null, 19.99, 107);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(42, 4, null, 39.99, 17);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(43, 1, null, 12.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(43, 2, null, 22.99, 16);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(43, 3, null, 29.99, 155);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(43, 4, null, 44.99, 2);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(44, 2, null, 12.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(44, 3, null, 19.99, 38);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(44, 4, null, 39.99, 22);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(45, 1, null, 12.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(45, 2, null, 19.99, 17);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(45, 3, null, 29.99, 81);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(45, 4, null, 43.99, 24);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(46, 3, null, 29.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(46, 4, null, 39.99, 27);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(47, 3, null, 19.99, 33);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(47, 4, null, 29.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(48, 3, null, 39.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(48, 4, null, 45.99, 1);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(49, 3, null, 26.99, 14);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(49, 4, null, 39.99, 8);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(50, 3, null, 49.99, 47);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(50, 4, null, 79.99, 7);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 2, 1, 19.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 3, 1, 24.99, 90);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 3, 2, 47.99, 90);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 3, 3, 47.99, 90);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 3, 4, 47.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 4, 1, 39.99, 49);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 4, 2, 59.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(51, 4, 3, 59.99, 0);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(52, 3, 1, 24.99, 25);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(52, 3, 2, 47.99, 25);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(52, 3, 3, 47.99, 25);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(52, 3, 4, 47.99, 0);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(52, 4, 1, 39.99, 13);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(53, 2, null, 14.99, 36);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(53, 3, null, 24.99, 42);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(53, 4, null, 39.99, 15);

insert into products(plant_id, size_id, pot_type_id, price, stock) values(54, 3, null, 19.99, 33);
insert into products(plant_id, size_id, pot_type_id, price, stock) values(54, 4, null, 39.99, 0);

-- insert values for images

insert into images(product_id, url) values();
	
use green_room;

select * from roles;

select * from users;

select * from types_plant;

select * from sizes;

select * from pot_types;

select * from plants;


select count(*) from plants where type_plant=3;
select * from plants where type_plant=3;
select * from plants where is_rare = true;


select * from products;

select * from products where plant_id=13;
select distinct size_id from products where plant_id=13;

select * from carts;

select * from cart_items;

select * from orders;

select * from order_items;

select * from images;

use green_room;
select * from plants;
select * from sizes;
select * from pot_types;

use green_room;


