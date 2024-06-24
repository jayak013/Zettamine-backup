import {createSlice} from '@reduxjs/toolkit'

const cartSlice = createSlice({
    name : 'cart',

    initialState:{
        cartList:[],
        total:0
    },
    
    reducers: {
        add(state,action){
            const check = state.cartList.findIndex(item => item.id === action.payload.id)
            if(check===-1){
                state.cartList.push(action.payload)
                state.total += action.payload.price
            }
        },
        remove(state,action){
            const indexToRemove = state.cartList.findIndex(item => item.id === action.payload.id)
            if(indexToRemove !==-1){
                state.total -= state.cartList[indexToRemove].price;
                state.cartList.splice(indexToRemove,1)
            }
        }
    }
})

export const {add, remove} = cartSlice.actions;
export const cartReducer = cartSlice.reducer;
