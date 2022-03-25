INSERT INTO wall_brackets (id, size, ajustable, name, price) VALUES (1001, '25X32', false, 'LG bracket', 32.23);
INSERT INTO wall_brackets (id, size, ajustable, name, price) VALUES (1002, '25X32/32X40', true, 'LG bracket', 32.23);
INSERT INTO wall_brackets (id, size, ajustable, name, price) VALUES (1003, '25X25', false, 'Philips bracket', 32.23);
INSERT INTO wall_brackets (id, size, ajustable, name, price) VALUES (1004, '25X32/32X40', true, 'Nikkei bracket', 32.23);
INSERT INTO wall_brackets (id, size, ajustable, name, price) VALUES (1005, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO ci_modules (id, name, price, type) VALUES (1001, 'universal CI-module', 32.5, '23JI12');
INSERT INTO ci_modules (id, name, price, type) VALUES (1002, 'Ziggo CI-module', 38.5, 'Z52412');
INSERT INTO ci_modules (id, name, price, type) VALUES (1003, 'Quantis', 98.5, 'v3.1');

INSERT INTO remotecontrollers (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1001, 'NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 12.99, 235885);
INSERT INTO remotecontrollers (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1002, '43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 12.99, 235885);
INSERT INTO remotecontrollers (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1003, 'OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 12.99, 235885);

INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1001, 'NH3216SMART', 'Nikkei', 'HD smart TV', 159, 32, 100, 'LED', 'HD ready',  true, true, false, false, false, false, 235885, 45896);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1002, '43PUS6504/12/L', 'Philips', '4K UHD LED Smart Tv', 379, 43, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 8569452, 5685489);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1003, '43PUS6504/12/M', 'Philips', '4K UHD LED Smart Tv', 379, 50, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 345549, 244486);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1004, '43PUS6504/12/S', 'Philips', '4K UHD LED Smart Tv', 379, 58, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 6548945, 4485741);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1005, 'OLED55C16LA', 'LG', 'LG OLED55C16LA', 989, 55, 100, 'OLED', 'ULTRA HD',  true, true, true, true, true, false, 50000, 20500);

INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1001, 1001);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1001, 1002);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1002, 1001);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1002, 1003);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1003, 1005);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1004, 1001);
INSERT INTO televisions_wallbrackets (wallbracket_id, television_id) VALUES (1005, 1001);
