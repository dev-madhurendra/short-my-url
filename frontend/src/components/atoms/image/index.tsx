import { IMAGE_DATATESTID } from "../../../utils/constants";

interface ImageComponentProps {
  src: string;
  height?: string;
  width?: string;
}

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
