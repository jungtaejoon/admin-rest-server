INSERT INTO user (email, password, name)
  SELECT * FROM (SELECT 'jungtaejoon@gmail.com', '$2a$10$M4VHgjow.RuOhC2O24Jujud9H6YD5e5X0De1iKzDA85l6vMVBYgRm', '정태준') AS tmp
  WHERE NOT EXISTS (
      SELECT * FROM user WHERE email = 'jungtaejoon@gmail.com'
  ) LIMIT 1;