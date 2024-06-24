import "./ProductCard.css";
import { add,remove } from "../store/cartSlice";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";

export const ProductCard = ({product}) => {
 const dispatch = useDispatch();
  const {name, price, image} = product;
  const products = useSelector(state => state.cartState.cartList)
  const find = products.some(item => item.id === product.id)

  return (
    <div className="productCard">
      <img src={image} alt={name} />
      <p className="name">{name}</p>
      <div className="action">
        <p>${price}</p>
        {
          !find?(<button onClick={()=>dispatch(add(product))}>Add To Cart</button>):
          (<button onClick={()=>dispatch(remove(product))} style={{backgroundColor:'red'}}>Remove</button>)
        }
      </div>
    </div>
  )
}
