import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Image } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const styles = StyleSheet.create({
  headerContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    alignItems: 'center',
    backgroundColor: '#f2f2f2',
    paddingTop: 40,
    paddingHorizontal: 10,
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
  },
  navItem: {
    fontSize: 13,
    fontWeight: 'bold',
    marginHorizontal: 10,
    marginVertical: 5,
    padding: 5,
    borderRadius: 5,
    backgroundColor: '#fff',
    color: '#333',
  },
});

function Menu() {
  const navigation = useNavigation();

  const handlePokemonPress = (pokemonId) => {
    navigation.navigate('PokedexList', { id: pokemonId });
  };

  return (
    <View style={styles.headerContainer}>
      <TouchableOpacity onPress={() => handlePokemonPress(1)}>
        <Text style={styles.navItem}>Gen 1</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(2)}>
        <Text style={styles.navItem}>Gen 2</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(3)}>
        <Text style={styles.navItem}>Gen 3</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(4)}>
        <Text style={styles.navItem}>Gen 4</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(5)}>
        <Text style={styles.navItem}>Gen 5</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(6)}>
        <Text style={styles.navItem}>Gen 6</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(7)}>
        <Text style={styles.navItem}>Gen 7</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(8)}>
        <Text style={styles.navItem}>Gen 8</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => handlePokemonPress(9)}>
              <Text style={styles.navItem}>Gen 9</Text>
            </TouchableOpacity>
    </View>
  );
}

export default Menu;