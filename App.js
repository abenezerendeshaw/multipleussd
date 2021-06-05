/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';

import CustomModule from './CustomModule'

import {
 Text,
  View,
} from 'react-native';


function App(){
CustomModule.show();
  return(

    <View>
      <Text>Hello</Text>
    </View>

  );

}


export default App;
