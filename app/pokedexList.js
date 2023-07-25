import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, ScrollView, TouchableOpacity } from 'react-native';
import PokedexItem from './pokedexItem';
import { useNavigation, useRoute } from '@react-navigation/native';

function PokedexList() {
  const [data, setData] = useState(null);
  const navigation = useNavigation();
  const route = useRoute();

  useEffect(() => {
    const generationId = route.params?.id || 1;
    fetch(`https://pokebuildapi.fr/api/v1/pokemon/generation/${generationId}`)
      .then(response => response.json())
      .then(jsonData => setData(jsonData))
      .catch(error => console.error(error));
  }, [route.params]);

  const handlePokemonPress = (pokemonId) => {
    navigation.navigate('PokedexDetails', { id: pokemonId });
  };

  return (
    <>
      {data ? (
        <ScrollView contentContainerStyle={styles.table}>
          {data.map((pokemon) => (
            <TouchableOpacity key={pokemon.id} onPress={() => handlePokemonPress(pokemon.id)}>
              <PokedexItem data={pokemon} />
            </TouchableOpacity>
          ))}
        </ScrollView>
      ) : (
        <Text>Chargement des données...</Text>
      )}
    </>
  );
}

const styles = StyleSheet.create({
  table: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    alignItems: 'center',
  },
});

export default PokedexList;