import { Text, View, Image, StyleSheet } from 'react-native';
import { useRoute } from '@react-navigation/native';
import { TouchableOpacity } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import React, { useState, useEffect } from 'react';

function PokedexDetails() {
  const route = useRoute();
  const { id } = route.params;
  const [data, setData] = useState(null);
  const navigation = useNavigation();

  const fetchData = (pokemonId) => {
    fetch(`https://pokebuildapi.fr/api/v1/pokemon/${pokemonId}`)
      .then(response => response.json())
      .then(jsonData => setData(jsonData))
      .catch(error => console.error(error));
  };

  useEffect(() => {
    fetchData(id);
  }, [id]);

  const handlePokemonPress = (pokemonId) => {
    navigation.navigate('PokedexDetails', { id: pokemonId });
  };
  console.log(data)
  return (
    <>
      {data != null ? (
        <View key={data.id} >
          <View style={styles.desc}>
            <Text>{data.name}</Text>
            <Image source={{ uri: data.image }} style={{ width: 250, height: 250 }} />
          </View>
          <View style={styles.evo}>
              <Text>préEvolution :</Text>
              {data.apiPreEvolution && data.apiPreEvolution.name ? (
                <TouchableOpacity onPress={() => handlePokemonPress(data.apiPreEvolution.pokedexIdd)}>
                  <Text>{data.apiPreEvolution.name}</Text>
                </TouchableOpacity>
              ) : (
                <Text>aucune</Text>
              )}
              <Text>évolution : {data.apiEvolutions[0] ? (
                <TouchableOpacity onPress={() => handlePokemonPress(data.apiEvolutions[0].pokedexId)}>
                  <Text>{data.apiEvolutions[0].name}</Text>
                </TouchableOpacity>
              ) : "aucune"}</Text>
          </View>
          <Image source={{ uri: data.sprite }} style={{ width: 100, height: 100 }} />
          <View style={styles.types}>
            {data["apiTypes"].map(
              (types, id) => 
              <View key={id}>
              <Text>
                {types.name}
              </Text>
              <Image source={{uri: types.image}} style={{width:20, height:20}}/>
              </View>
              )}
           </View> 
          <View style={styles.table}>
            {Object.entries(data.stats).map(([key, value]) => {
              return (
              <View key={key} style={styles.row}>
                <Text style={styles.label}>{key}</Text>
                <Text style={styles.value}>{value}</Text>
              </View>);
            })}
          </View>
        </View>
      ) : (
        <Text>Chargement des données...</Text>

      )}
    </>
  );
}

const styles = StyleSheet.create({
  table: {
    borderWidth: 1,
    borderColor: 'black',
    padding: 10,
    borderRadius: 5,
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginBottom: 5,
  },
  label: {
    fontWeight: 'bold',
  },
  value: {
    marginLeft: 10,
  },
  types: {
    flexDirection: 'row',
    justifyContent: 'center'
  },
  desc: {
    alignItems: 'center',
  },
  evo: {
  flexDirection: 'row',
  justifyContent: 'space-between'
  }
});
export default PokedexDetails;