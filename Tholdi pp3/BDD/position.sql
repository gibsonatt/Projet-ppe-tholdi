-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 15 déc. 2020 à 23:00
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
-- Structure de la table `position`
--

CREATE TABLE `position` (
  `numposition` char(9) NOT NULL,
  `numemplacement` char(3) NOT NULL,
  `numallee` char(3) NOT NULL,
  `numquai` char(2) NOT NULL,
  `numetage` char(1) NOT NULL,
  `numcont` char(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `position`
--

INSERT INTO `position` (`numposition`, `numemplacement`, `numallee`, `numquai`, `numetage`, `numcont`) VALUES
('01001020', '02', '001', '01', '0', '123456789'),
('01001021', '02', '001', '01', '1', NULL),
('01001022', '02', '001', '01', '2', NULL),
('01001023', '02', '001', '01', '3', NULL),
('01001030', '03', '001', '01', '0', NULL),
('01001031', '03', '001', '01', '1', NULL),
('01001032', '03', '001', '01', '2', NULL),
('01001033', '03', '001', '01', '3', NULL),
('02001010', '01', '001', '02', '0', NULL),
('02001011', '01', '001', '02', '1', NULL),
('02001012', '01', '001', '02', '2', NULL),
('02001013', '01', '001', '02', '3', NULL),
('02001020', '02', '001', '02', '0', NULL),
('02001021', '02', '001', '02', '1', NULL),
('02001022', '02', '001', '02', '2', NULL),
('02001023', '02', '001', '02', '3', NULL),
('02001030', '03', '001', '02', '0', NULL),
('02001031', '03', '001', '02', '1', NULL),
('02001032', '03', '001', '02', '2', NULL),
('02001033', '03', '001', '02', '3', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`numposition`),
  ADD KEY `fk_Position_Emplacement` (`numemplacement`,`numallee`,`numquai`),
  ADD KEY `fk_Position_Leconteneur` (`numcont`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
