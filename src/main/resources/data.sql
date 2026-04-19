INSERT INTO personal_info (first_name,Last_name,title,profile_description,profile_image_url,years_of_experience,email,phone,linkedin_url,github_url) VALUES
('Juan','Perez','Full Stack Developer','Apasionado por desarrollo web','',2,'jperez@gmail.com','0994464375','','');

INSERT INTO skills (name, level_percentage, icon_class, personal_info_id) VALUES
('Java', 90, 'fab fa-java', 1),
('Spring Boot', 85, 'fas fa-leaf', 1),
('PostgreSQL', 80, 'fas fa-database', 1),
('HTML', 95, 'fab fa-html5', 1),
('CSS', 90, 'fab fa-css3-alt', 1),
('JavaScript', 75, 'fab fa-js-square', 1),
('React', 70, 'fab fa-react', 1);

INSERT INTO educations (degree,institution,start_date,end_date,description,personal_info_id) VALUES
('Ingenieria en Sistemas','Universidad XYZ','2015-03-01','2020-12-15','Escpecializacion en desarrollo Web',1);

INSERT INTO experiences (job_title,company_name,start_date,end_date,description,personal_info_id) VALUES
('Desarrollador full stack Senior','Viamatica S.A','2022-01-01',NULL,'Desarrollo y mantenimiento de aplicaciones web',1);


INSERT INTO projects (title, description, image_url, project_url, personal_info_id) VALUES
('Portfolio Personal', 'Un portafolio web para mostrar mis habilidades y proyectos.', 'img/projects/project2.jpg', 'https://github.com/myusername/my-portfolio', 1),
('Aplicación de E-commerce', 'Plataforma de comercio electrónico con carrito de compras y pasarela de pago.', 'img/projects/project1.jpg', 'https://github.com/myusername/ecommerce-app', 1);

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$DvZo0TmfdGH8rCWvQHE38.Ubcv6Yn4ubd5ymximYpXJ8KlnzG6RhG', TRUE);