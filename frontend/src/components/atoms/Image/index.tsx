import { IMAGE_DATATESTID } from "../../../utils/constants";
import { ImageComponentProps } from "../../../utils/interfaces";


const ImageComponent = ({ src, height, width }: ImageComponentProps) => {
  return (
    <img
      data-testid={IMAGE_DATATESTID}
      src={src}
      width={width}
      height={height}
    ></img>
  );
};

export default ImageComponent;
