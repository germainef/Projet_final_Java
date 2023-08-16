-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 06 août 2023 à 18:43
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdgestionecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_etudiant`
--

CREATE TABLE `t_etudiant` (
  `id` int(11) NOT NULL,
  `matricule` varchar(10) NOT NULL,
  `nomComplet` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `promotion` varchar(255) NOT NULL,
  `resultat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_etudiant`
--

INSERT INTO `t_etudiant` (`id`, `matricule`, `nomComplet`, `tel`, `promotion`, `resultat`) VALUES
(2, '0013', 'Mwembo', '9042', 'L5', '80%'),
(3, '0017', 'Germaine', '097567652', 'L2', '70%');

-- --------------------------------------------------------

--
-- Structure de la table `t_frais`
--

CREATE TABLE `t_frais` (
  `id` int(11) NOT NULL,
  `montantPaye` varchar(11) NOT NULL,
  `matriculeEtudiant` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_frais`
--

INSERT INTO `t_frais` (`id`, `montantPaye`, `matriculeEtudiant`) VALUES
(1, '900', '0013'),
(3, '900', '0017');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `t_etudiant`
--
ALTER TABLE `t_etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `t_frais`
--
ALTER TABLE `t_frais`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `t_etudiant`
--
ALTER TABLE `t_etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `t_frais`
--
ALTER TABLE `t_frais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
