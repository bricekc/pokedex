import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, View } from 'react-native';
import PokedexList from './app/pokedexList';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import PokedexDetails from './app/pokedexDetails';
import Menu from './app/menu';

const Stack = createStackNavigator();

export default function App() {
  return (
    <View style={styles.table}>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="PokedexList" component={PokedexList} options={{header: ()=> <Menu/>}}/>
          <Stack.Screen name="PokedexDetails" component={PokedexDetails} />
        </Stack.Navigator>
      </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create(
  {
    table: {
      flex: 1,
    }
  });