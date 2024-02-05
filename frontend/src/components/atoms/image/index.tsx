import React from "react";
import { image_DataTestId } from "../../../utils/constants";

interface ImageComponentProps {
  src: string;
  height?: string;
  width?: string;
}

const ImageComponent = ({src,height,width}: ImageComponentProps) => {
  return <img data-testid={image_DataTestId} src={src} width={width} height={height}></img>;
};

export default ImageComponent