import { IconComponentProps } from "../../../utils/interfaces";

const IconComponent = (props: IconComponentProps) => {
    const { src, width, height, padding } = props;
    return (
      <div>
        <img
          data-testid="iconComponent"
          src={src}
          width={width}
          height={height}
          style={{ padding }}
          alt="icon"
        />
      </div>
    );
  };
  
  export default IconComponent;