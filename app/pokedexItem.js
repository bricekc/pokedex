import React from 'react';
import { View, Text, Image } from 'react-native';

function PokedexItem({ data }) {
  return (
    <View key={data.id}>
      <Image source={{ uri: data.image }} style={{ width: 100, height: 100 }} />
            <Text>{data.name}</Text>
    </View>
  );
}

export default PokedexItem;