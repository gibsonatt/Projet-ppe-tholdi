-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 15 déc. 2020 à 22:59
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tholdiport`
--

-- --------------------------------------------------------

--
-- Structure de la table `contener`
--

CREATE TABLE `contener` (
  `contcode` char(2) NOT NULL,
  `conttype` int(11) NOT NULL,
  `conttaille` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contener`
--

INSERT INTO `contener` (`contcode`, `conttype`, `conttaille`) VALUES
('11', 1, 1),
('21', 2, 1),
('31', 3, 1),
('41', 4, 1),
('51', 5, 1),
('12', 1, 2),
('22', 2, 2),
('32', 3, 2),
('42', 4, 2),
('52', 5, 2),
('13', 1, 3),
('23', 2, 3),
('33', 3, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contener`
--
ALTER TABLE `contener`
  ADD PRIMARY KEY (`contcode`),
  ADD KEY `fk_contener_type` (`conttype`),
  ADD KEY `fk_contener_taille` (`conttaille`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
