
CREATE TABLE `bankstate` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `date_state` datetime DEFAULT NULL,
  `gain` double NOT NULL,
  `real_bank` double NOT NULL,
  `spent` double NOT NULL,
  `virtual_bank` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `categoryname` varchar(255) NOT NULL,
  `flag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `clientname` varchar(255) NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `nature` int(11) DEFAULT NULL,
  `tel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conditioning`
--

CREATE TABLE `conditioning` (
  `id` bigint(20) NOT NULL,
  `conditioningname` varchar(100) NOT NULL,
  `flag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `brday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `lastname` varchar(255) NOT NULL,
  `matricul` varchar(50) NOT NULL,
  `numpiece` varchar(255) DEFAULT NULL,
  `piece` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  `tel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enterprise`
--

CREATE TABLE `enterprise` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `capital` double NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enterprisename` varchar(40) DEFAULT NULL,
  `juridic_form` int(11) DEFAULT NULL,
  `ninea` varchar(255) DEFAULT NULL,
  `phones` varchar(100) NOT NULL,
  `rc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `oparionstate`
--

CREATE TABLE `oparionstate` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `checkout` double DEFAULT NULL,
  `date_state` datetime DEFAULT NULL,
  `gain` double NOT NULL,
  `spent` double NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `operation_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `operationdate` datetime DEFAULT NULL,
  `operationtype` int(11) DEFAULT NULL,
  `payable` bit(1) NOT NULL,
  `payment_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total_ht` double DEFAULT NULL,
  `total_ttc` double NOT NULL,
  `tva` double NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `operation_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `operationrow`
--

CREATE TABLE `operationrow` (
  `id` bigint(20) NOT NULL,
  `mount` double NOT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `operation_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `payment`
--

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `amount` double NOT NULL,
  `datenext_pym` datetime DEFAULT NULL,
  `part` int(11) DEFAULT NULL,
  `rest` double NOT NULL,
  `state` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `operation_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `min_sale_price` double DEFAULT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `purchase_price` double DEFAULT NULL,
  `qnt` double DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `conditioning_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `stocktaking`
--

CREATE TABLE `stocktaking` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `date_stk` datetime NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `stock_state` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `peopleid` bigint(20) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `target` int(11) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bankstate`
--
ALTER TABLE `bankstate`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK29gntjt80v5dpmg9ejhxq1cl6` (`categoryname`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKrqeipc8c3g6mm43xt351k7nvu` (`tel`),
  ADD UNIQUE KEY `UKbfgjs3fem0hmjhvih80158x29` (`email`);

--
-- Index pour la table `conditioning`
--
ALTER TABLE `conditioning`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK23jiby0bu6vtggt03cn3c8n6d` (`conditioningname`);

--
-- Index pour la table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr53oddf7iew6un6oq2podpmk` (`tel`),
  ADD UNIQUE KEY `UK8sio95amhrm3coq194ncdm9r1` (`matricul`),
  ADD UNIQUE KEY `UKfopic1oh5oln2khj8eat6ino0` (`email`),
  ADD UNIQUE KEY `UKlvex7hsn8poy4vi001fms69pi` (`numpiece`);

--
-- Index pour la table `enterprise`
--
ALTER TABLE `enterprise`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `oparionstate`
--
ALTER TABLE `oparionstate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl2as4krcabeyowt5tm02kgs2o` (`category_id`),
  ADD KEY `FKr63fw4v3bb4kdumy5k5jxq77r` (`operation_id`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiwcyjtcuc5n54j4tadowmkxdn` (`client_id`),
  ADD KEY `FKk127hwobcg8dgk94iwua1kxpa` (`employee_id`),
  ADD KEY `FKs0qr8m52dfhll7bvv92ajem84` (`operation_id`);

--
-- Index pour la table `operationrow`
--
ALTER TABLE `operationrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3q7u47ioq8i6qaff7ets775x9` (`operation_id`),
  ADD KEY `FK9e5a06mf0pk8kc2oeqeint2a9` (`product_id`);

--
-- Index pour la table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK85d63fdn2u30kthiridlbhfnc` (`operation_id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6aqixgrjm2rrw2is6ol1nxq1b` (`productname`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  ADD KEY `FKnbo6mboteod419amm0ulay0vk` (`conditioning_id`);

--
-- Index pour la table `stocktaking`
--
ALTER TABLE `stocktaking`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKgj09wdj5b5kexb7kesvc0skhu` (`date_stk`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bankstate`
--
ALTER TABLE `bankstate`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `conditioning`
--
ALTER TABLE `conditioning`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `enterprise`
--
ALTER TABLE `enterprise`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `oparionstate`
--
ALTER TABLE `oparionstate`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `operationrow`
--
ALTER TABLE `operationrow`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `stocktaking`
--
ALTER TABLE `stocktaking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `oparionstate`
--
ALTER TABLE `oparionstate`
  ADD CONSTRAINT `FKl2as4krcabeyowt5tm02kgs2o` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKr63fw4v3bb4kdumy5k5jxq77r` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FKiwcyjtcuc5n54j4tadowmkxdn` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKk127hwobcg8dgk94iwua1kxpa` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKs0qr8m52dfhll7bvv92ajem84` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`);

--
-- Contraintes pour la table `operationrow`
--
ALTER TABLE `operationrow`
  ADD CONSTRAINT `FK3q7u47ioq8i6qaff7ets775x9` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`),
  ADD CONSTRAINT `FK9e5a06mf0pk8kc2oeqeint2a9` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Contraintes pour la table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK85d63fdn2u30kthiridlbhfnc` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKnbo6mboteod419amm0ulay0vk` FOREIGN KEY (`conditioning_id`) REFERENCES `conditioning` (`id`);
COMMIT;













INSERT INTO `users` (`id`, `created_at`, `updated_at`, `email`, `flag`, `password`, `role`, `peopleid`, `target`, `username`) VALUES
(1, '2020-07-06 10:10:12', '2020-07-07 15:36:08', 'dr360@gmail.com', 0, '$2a$10$ZoFptAtzCERf1SvQO7QtQ..4A7fB44YLigO9mXQh4fHh5Ya9dN4mu', 2, NULL, 2, 'dial'),
(2, '2020-07-06 10:12:05', '2020-07-06 10:12:05', 'dr@gmail.com', 0, '$2a$10$8RFaSXzsMbrrHUYweIuJHeB6wj01ycKkxwMt6xhqwnT8J7PrxiFXa', 0, NULL, 2, 'dialr'),
(3, '2020-07-09 21:35:26', '2020-07-09 22:22:14', 'dodo@gmail.com', 1, '$2a$10$UPID/hQF7ibpCkJikCtf5OEJC/fsSH7cXQ7ebKzKsDmRlMDHShluG', 0, NULL, 1, 'dado');



INSERT INTO `category` (`id`, `created_at`, `updated_at`, `categoryname`, `flag`) VALUES
(1, 'telephones', 0),
(2, 'ordinateurs', 0);



INSERT INTO `conditioning` (`id`, `conditioningname`, `flag`) VALUES
(1, 'unité', 0),
(2, 'carton', 0);



INSERT INTO `product` (`id`, `created_at`, `updated_at`, `flag`, `min_sale_price`, `productname`, `purchase_price`, `qnt`, `sale_price`, `category_id`, `conditioning_id`) VALUES
(1, 0, 120000, 'Samsung S5 ', 100000, 0, 200000, 1, 1),
(2,  0, 1200000, 'carton Samsung S5 ', 1000000, 0, 1900000, 1, 2),
(3,  0, 250000, 'HP Notebook v17 ', 200000, 0, 300000, 2, 1),
(4, 0, 350000, 'Lonovo ThindPad 90 ', 300000, 0, 400000, 2, 1);





